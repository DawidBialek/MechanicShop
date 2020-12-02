package com.DawidBialek.mechanicShop.order;

import com.DawidBialek.mechanicShop.order.OrderNotFoundException;
import com.DawidBialek.mechanicShop.order.OrderRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    private final OrderRepository repository;

    public OrderController(OrderRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/orders")
    List<Order> all(){
        return repository.findAll();
    }

    @PostMapping("/orders")
    Order newOrder(@RequestBody Order newOrder){
        return repository.save(newOrder);
    }

    @GetMapping("/orders/{id}")
    Order one(@PathVariable Long id){
        return repository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
    }

    @PutMapping("/orders/{id}")
    Order replaceOrder(@RequestBody Order newOrder, @PathVariable Long id){
        return repository.findById(id)
                .map(Order -> {
                    newOrder.setId(id);
                    newOrder.setCustomerId(newOrder.getCustomerId());
                    newOrder.setCarId(newOrder.getCarId());
                    newOrder.setDescription(newOrder.getDescription());
                    newOrder.setName(newOrder.getName());
                    newOrder.setPrice(newOrder.getPrice());
                    return repository.save(newOrder);
                })
                .orElseGet(() -> {
                    newOrder.setId(id);
                    return repository.save(newOrder);
                });
    }

    @DeleteMapping("orders/{id}")
    void deleteOrder(@PathVariable Long id){
        repository.deleteById(id);
    }
}
