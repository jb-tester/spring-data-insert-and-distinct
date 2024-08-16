package com.mytests.spring.springdatadistinct;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface MyDataRepository extends CrudRepository<MyData, Integer> {

    // 'distinct' keyword is not parsed properly inside 'listagg': https://youtrack.jetbrains.com/issue/IDEA-341776
    @Query("""
            select new com.mytests.spring.springdatadistinct.MyDataDTO(
                data.num1,
                data.num2,
                data.firststr,
                listagg(distinct data.secondstr,'+') over (partition by data.num1)
            ) from MyData data""")
    List<MyDataDTO> someQuery0();

    // 'distinct' keyword in count()
    @Query("""
            select count(distinct data.num1) from MyData data
            """)
    Long someQuery1();

    // 'distinct' keyword is not parsed properly inside 'listagg': https://youtrack.jetbrains.com/issue/IDEA-341776
    @Query("""
            select new com.mytests.spring.springdatadistinct.MyDataDTO(
                data.num1,
                data.num2,
                data.firststr,
                concat('<', listagg(distinct concat(data.secondstr, data.thirdstr, data.fourthstr, data.fifthstr),''),'>')
            ) from MyData data group by data.num1, data.num2""")
    List<MyDataDTO> someQuery2();

    // 'is distinct', 'is not distinct' are not parsed properly in 'where' clause: https://youtrack.jetbrains.com/issue/IDEA-304859
    @Query("select data from MyData data where data.num3 is distinct from :arg1 and data.num1 is not distinct from :arg2")
    List<MyData> someQuery3(@Param("arg1") int arg, @Param("arg2") int arg2);

    // 'distinct' here is parsed properly:
    @Query("select distinct(data.firststr) from MyData data ")
    List<String> someQuery4();

}
