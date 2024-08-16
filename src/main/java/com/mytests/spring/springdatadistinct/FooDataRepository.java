package com.mytests.spring.springdatadistinct;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * *
 * <p>Created by irina on 8/16/2024.</p>
 * *
 */
public interface FooDataRepository extends CrudRepository<FooData, Integer> {
    @Modifying
    @Query("insert into FooData(id,str,number) values (:id, :str, :number)")
    void saveFooData(@Param("id") Integer id, @Param("str") String str, @Param("number") int number);
}
