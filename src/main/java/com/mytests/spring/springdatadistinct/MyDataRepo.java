package com.mytests.spring.springdatadistinct;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Repository;

@Repository
public class MyDataRepo {

    private final EntityManager entityManager;

    public MyDataRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void populateData(){
        // false-positive errors in these queries:
        String insertQ1 = "INSERT INTO MyData (id, firststr, secondstr, thirdstr, fourthstr, fifthstr, num1, num2, num3) VALUES (1, 'str11','str12','str13','str14','str15', 11,12,13)";
        String insertQ2 = "INSERT INTO MyData (id, firststr, secondstr, thirdstr, fourthstr, fifthstr, num1, num2, num3) VALUES (2, 'str21','str22','str23','str24','str25', 21,22,23)";
        String insertQ3 = "INSERT INTO MyData (id, firststr, secondstr, thirdstr, fourthstr, fifthstr, num1, num2, num3) VALUES (3, 'str31','str32','str33','str34','str35', 21,32,33)";
        String insertQ4 = "INSERT INTO MyData (id, firststr, secondstr, thirdstr, fourthstr, fifthstr, num1, num2, num3) VALUES (4, 'str31','str42','str43','str44','str45', 41,42,43)";
        entityManager.createQuery(insertQ1).executeUpdate();
        entityManager.createQuery(insertQ2).executeUpdate();
        entityManager.createQuery(insertQ3).executeUpdate();
        entityManager.createQuery(insertQ4).executeUpdate();
    }
    @Transactional
    public void useNamedInsertQuery(int arg1, int arg2){
        System.out.println("*************** Use the named query to insert the data: *******************");
        System.out.println("Initial FooData state: ");
        System.out.println(entityManager.createQuery("select d from FooData d").getResultList());
        entityManager.createNamedQuery("myInsertQuery").setParameter("arg1", arg1).setParameter("arg2", arg2).executeUpdate();
        System.out.println("After update: ");
        System.out.println(entityManager.createQuery("select d from FooData d").getResultList());
        System.out.println("***************************************************************************");
    }

}
