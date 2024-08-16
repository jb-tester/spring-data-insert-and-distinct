package com.mytests.spring.springdatadistinct;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FoDataRepositoryService {

    private final FooDataRepository fooDataRepository;

    public FoDataRepositoryService(FooDataRepository fooDataRepository) {
        this.fooDataRepository = fooDataRepository;
    }

    @Transactional
    public void insertData() {
        fooDataRepository.saveFooData(10, "dummy", 100);
    }

    public void displayData() {
        fooDataRepository.findAll().forEach(System.out::println);
    }
}
