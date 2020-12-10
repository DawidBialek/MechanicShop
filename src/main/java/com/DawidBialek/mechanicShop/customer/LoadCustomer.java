package com.DawidBialek.mechanicShop.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadCustomer {

    private static final Logger log = LoggerFactory.getLogger(LoadCustomer.class);

    @Bean
    CommandLineRunner loadCustomer(CustomerRepository repository){

        return args -> {
            log.info("Preloading " + repository.save(new Customer("Joe","Smith", "Joe@gmail.com")));
            log.info("Preloading " + repository.save(new Customer("Adam", "Ocean", "Adam@gmail.com")));
        };
    }
}
