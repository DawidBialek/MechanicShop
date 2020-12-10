package com.DawidBialek.mechanicShop.customer;


import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CustomerController {

    private final CustomerRepository repository;

    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/customers")
    List<Customer> all() {return repository.findAll();}

    @PostMapping("/customers")
    Customer newCustomer(@RequestBody Customer newCustomer){return repository.save(newCustomer);}

    @GetMapping("/customers/{id}")
    Customer one(@PathVariable Long id){
        return repository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
    }

    @PutMapping("/customers/{id}")
    Customer replaceCustomer(@RequestBody Customer newCustomer, @PathVariable Long id){
        return repository.findById(id)
                .map(customer -> {
                    customer.setFirstName(newCustomer.getFirstName());
                    customer.setLastName(newCustomer.getLastName());
                    customer.setEmail(newCustomer.getEmail());
                    return repository.save(newCustomer);
                })
                .orElseGet(() -> {
                    newCustomer.setId(id);
                    return repository.save(newCustomer);
                });
    }
}
