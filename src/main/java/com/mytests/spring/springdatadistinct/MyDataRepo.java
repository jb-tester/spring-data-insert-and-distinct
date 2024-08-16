package com.mytests.spring.springdatadistinct;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class MyDataRepo {

    private final EntityManager entityManager;

    public MyDataRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void populateData(){

        // false-positive errors in these queries: https://youtrack.jetbrains.com/issue/IDEA-341902
        String insertQ1 = "INSERT INTO MyData (firststr, secondstr, thirdstr, fourthstr, fifthstr, num1, num2, num3) VALUES ('str11','str12','str13','str14','str15', 11,12,13)";
        String insertQ2 = "INSERT INTO MyData (firststr, secondstr, thirdstr, fourthstr, fifthstr, num1, num2, num3) VALUES ('str21','str22','str23','str24','str25', 21,22,23)";
        String insertQ3 = "INSERT INTO MyData (firststr, secondstr, thirdstr, fourthstr, fifthstr, num1, num2, num3) VALUES ('str31','str32','str33','str34','str35', 21,32,33)";
        String insertQ4 = "INSERT INTO MyData (firststr, secondstr, thirdstr, fourthstr, fifthstr, num1, num2, num3) VALUES ('str41','str42','str43','str44','str45', 41,42,43) ON CONFLICT(firststr) do update set firststr = '___'";
        String insertQ5 = "INSERT INTO MyData (firststr, secondstr, thirdstr, fourthstr, fifthstr, num1, num2, num3) VALUES ('str51','str52','str53','str54','str55', 51,52,53) ON DUPLICATE KEY UPDATE firststr = VALUES(firststr)";
        entityManager.createQuery(insertQ1).executeUpdate();
        entityManager.createQuery(insertQ2).executeUpdate();
        entityManager.createQuery(insertQ3).executeUpdate();
      //  entityManager.createQuery(insertQ4).executeUpdate();
      //  entityManager.createQuery(insertQ5).executeUpdate();

    }


}
