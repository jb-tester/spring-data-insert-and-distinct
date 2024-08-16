package com.mytests.spring.springdatadistinct;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class FooDataRepo {
   final EntityManager entityManager;

    public FooDataRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void useNamedInsertQuery(int arg1, int arg2){
        System.out.println("Initial FooData state: ");
        System.out.println(entityManager.createQuery("select d from FooData d").getResultList());
        entityManager.createNamedQuery("myInsertQuery").setParameter("arg1", arg1).setParameter("arg2", arg2).executeUpdate();
        System.out.println("After update: ");
        System.out.println(entityManager.createQuery("select d from FooData d").getResultList());
    }
}
