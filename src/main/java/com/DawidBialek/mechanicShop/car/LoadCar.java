package com.DawidBialek.mechanicShop.car;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadCar {
    private static final Logger log = LoggerFactory.getLogger(LoadCar.class);

//    @Bean
//    CommandLineRunner loadCarTable(CarRepository repository) {
//
//        return args -> {
//            log.info("Preloading " + repository.save(new Car("Mazda", "3")));
//            log.info("Preloading " + repository.save(new Car("Peugeot", "106")));
//        };
//    }

}
