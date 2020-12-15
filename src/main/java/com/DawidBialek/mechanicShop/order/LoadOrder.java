package com.DawidBialek.mechanicShop.order;

import com.DawidBialek.mechanicShop.car.Car;
import com.DawidBialek.mechanicShop.customer.Customer;
import com.DawidBialek.mechanicShop.employee.Employee;
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
    CommandLineRunner loadOrderTable(OrderRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Order("Replace Ignition Coil", "Somethings wrong with coil in this car",new Employee("Adam","Mickiewicz", "Mechanic", 2000.0) , new Car("Mazda", "3"), new Customer("Joe","Smith", "Joe@gmail.com"), 200.0)));
            log.info("Preloading " + repository.save(new Order("Replace water pump", "Fix the water pump, pressure in the system is too low", new Employee("Tomasz", "Nowak", "Electrician", 2200.0), new Car("Peugeot", "106"), new Customer("Adam", "Ocean", "Adam@gmail.com"), 390.0)));
        };
    }
}
