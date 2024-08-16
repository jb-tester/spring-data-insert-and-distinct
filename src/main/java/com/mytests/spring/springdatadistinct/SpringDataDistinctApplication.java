package com.mytests.spring.springdatadistinct;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataDistinctApplication implements CommandLineRunner {

    private final MyDataRepo repo;
    private final MyDataRepository myDataRepository;
    private final FooDataRepo fooDataRepo;
    private final FoDataRepositoryService foDataRepositoryService;

    public SpringDataDistinctApplication(MyDataRepo repo, MyDataRepository myDataRepository, FooDataRepo fooDataRepo,  FoDataRepositoryService foDataRepositoryService) {
        this.repo = repo;
        this.myDataRepository = myDataRepository;
        this.fooDataRepo = fooDataRepo;
        this.foDataRepositoryService = foDataRepositoryService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDataDistinctApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repo.populateData();
        System.out.println("*********************** initial data: *********************************************************");
        for (MyData myData : myDataRepository.findAll()) {
            System.out.println(myData);
        }
        System.out.println("*********************** use 'is distinct from' in 'where' clause: *****************************");
        for (MyData myData : myDataRepository.someQuery3(33, 21)) {
            System.out.println(myData);
        }
        System.out.println("*********************** use 'distinct' in 'select' clause: ************************************");
        for (String myData : myDataRepository.someQuery4()) {
            System.out.println(myData);
        }
        System.out.println("*********************** use 'concat', 'distinct' and 'listagg' in query: **********************");
        for (MyDataDTO myData : myDataRepository.someQuery2()) {
            System.out.println(myData);
        }
        System.out.println("************************** use 'distinct' inside 'listagg' in query: **************************");
        for (MyDataDTO myData : myDataRepository.someQuery0()) {
            System.out.println(myData);
        }
        System.out.println("************************** use 'distinct' inside 'count' in query: ***************************");
        System.out.println(myDataRepository.someQuery1());
        System.out.println("***********************************************************************************************");
        System.out.println("************************** use 'insert' in the named query: ***************************");
        fooDataRepo.useNamedInsertQuery(12, 100);
        System.out.println("************************** use 'insert' in @Query: ***************************");
        foDataRepositoryService.insertData();
        foDataRepositoryService.displayData();
    }
}
