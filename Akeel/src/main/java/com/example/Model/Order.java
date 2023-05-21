package com.example.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

enum orderStatus {

    PREPARING,
    DELIVERED,
    CANCELED
}

@Entity
public class Order {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userID;
    //private Meal items; // ? was causing a problem, add setters and getters
    private double total;
    private int runnerID; //todo make fk
    private int restaurantID; //todo make fk

    @ManyToOne(targetEntity = com.example.Model.Customer.class)
    @JoinColumn(name="customer")
    private int customerID;
    private orderStatus status;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }


    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getRunnerID() {
        return runnerID;
    }

    public void setRunnerID(int runnerID) {
        this.runnerID = runnerID;
    }

    public int getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public orderStatus getStatus() {
        return status;
    }

    public void setStatus(orderStatus status) {
        this.status = status;
    }

    private Order() {}


}
