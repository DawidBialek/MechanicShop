package com.DawidBialek.mechanicShop.employee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadEmployee {

    private static final Logger log = LoggerFactory.getLogger(LoadEmployee.class);

//    @Bean
//    CommandLineRunner loadEmployeeTable(EmployeeRepository repository) {
//
//        return args -> {
//            log.info("Preloading " + repository.save(new Employee("Adam","Mickiewicz", "Mechanic", 2000.0)));
//            log.info("Preloading " + repository.save(new Employee("Tomasz", "Nowak", "Electrician", 2200.0)));
//        };
//    }
}
