package com.DawidBialek.mechanicShop.order;

import com.DawidBialek.mechanicShop.car.Car;
import com.DawidBialek.mechanicShop.customer.Customer;
import com.DawidBialek.mechanicShop.employee.Employee;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Order {

    private @Id @GeneratedValue Long id;
    private String name;
    private String description;

    @OneToOne
    @JoinColumn(name="employee_id")
    private Employee employeeId;
    @OneToOne
    @JoinColumn(name="car_id")
    private Car carId;
    @OneToOne
    @JoinColumn(name="customer_id")
    private Customer customerId;

    private double price;

    public Order() {
    }

    public Order(String name, String description, Employee employeeId, Car carId, Customer customerId, double price) {
        this.name = name;
        this.description = description;
        this.employeeId = employeeId;
        this.carId = carId;
        this.customerId = customerId;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public Car getCarId() {
        return carId;
    }

    public void setCarId(Car carId) {
        this.carId = carId;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Double.compare(order.price, price) == 0 &&
                Objects.equals(id, order.id) &&
                Objects.equals(name, order.name) &&
                Objects.equals(description, order.description) &&
                Objects.equals(employeeId, order.employeeId) &&
                Objects.equals(carId, order.carId) &&
                Objects.equals(customerId, order.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, employeeId, carId, customerId, price);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", employeeId=" + employeeId +
                ", carId=" + carId +
                ", customerId=" + customerId +
                ", price=" + price +
                '}';
    }
}
