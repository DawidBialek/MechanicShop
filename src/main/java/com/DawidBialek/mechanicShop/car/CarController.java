package com.DawidBialek.mechanicShop.car;

import com.DawidBialek.mechanicShop.car.Car;
import com.DawidBialek.mechanicShop.car.CarNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {
    
    private final CarRepository repository;

    public CarController(CarRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/cars")
    List<Car> all(){
        return repository.findAll();
    }

    @PostMapping("/cars")
    Car newCar(@RequestBody Car newCar){
        return repository.save(newCar);
    }

    @GetMapping("/cars/{id}")
    Car one(@PathVariable Long id){
        return repository.findById(id).orElseThrow(() -> new CarNotFoundException(id));
    }

    @PutMapping("/cars/{id}")
    Car replaceCar(@RequestBody Car newCar, @PathVariable Long id){
        return repository.findById(id)
                .map(Car -> {
                    Car.setMake(newCar.getMake());
                    Car.setModel(newCar.getModel());
                    return repository.save(newCar);
                })
                .orElseGet(() -> {
                    newCar.setId(id);
                    return repository.save(newCar);
                });
    }

    @DeleteMapping("cars/{id}")
    void deleteCar(@PathVariable Long id){
        repository.deleteById(id);
    }
}
