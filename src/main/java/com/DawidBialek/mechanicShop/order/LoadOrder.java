package com.DawidBialek.mechanicShop.order;

import com.DawidBialek.mechanicShop.order.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadOrder {

    private static final Logger log = LoggerFactory.getLogger(LoadOrder.class);

    @Bean
    CommandLineRunner loadOrder(OrderRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Order("Replace Ignition Coil", "Somethings wrong with coil in this car", Long.valueOf(1), Long.valueOf(1), Long.valueOf(1), 200.0)));
            log.info("Preloading " + repository.save(new Order("Replace water pump", "Fix the water pump, pressure in the system is too low", Long.valueOf(1), Long.valueOf(2), Long.valueOf(2), 390.0)));
        };
    }
}
