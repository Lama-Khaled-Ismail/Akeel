package com.example.Model;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.omg.PortableServer.IdAssignmentPolicyValue;

enum orderStatus {

    PREPARING,
    DELIVERED,
    CANCELED
}

@Entity
public class Order {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    @ManyToMany
    @JoinTable(
        name = "OrderXMeal",
        joinColumns=@JoinColumn(name="id"),
		inverseJoinColumns=@JoinColumn(name="mealID")
    )
    private Set<Meal> items;
    private double total;
    private LocalDateTime dateTime;

    
    @OneToOne
    @JoinColumn(name ="runnerID")
    private Runner runner;
    
    @ManyToOne
    @JoinColumn(name ="restaurantID")
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name="customerID")
    private Customer customer;
    private orderStatus status;

    
    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    
    public LocalDateTime getDateTime() {
        return dateTime;
    }


    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public double getTotal() {
        return total;
    }


    public void setTotal(double total) {
        this.total = total;
    }


    public Runner getRunner() {
        return runner;
    }


    public void setRunner(Runner runner) {
        this.runner = runner;
    }


    public Restaurant getRestaurant() {
        return restaurant;
    }


    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }


    public Customer getCustomer() {
        return customer;
    }


    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public orderStatus getStatus() {
        return status;
    }


    public void setStatus(orderStatus status) {
        this.status = status;
    }

    public void addMealItem(Meal meal){
        this.items.add(meal);
    }
    public Order() {}


}
