package com.example.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

 enum RUNNER_STATUS{
    AVAILABLE("Available") , BUSY("Busy");

    String key;

    RUNNER_STATUS(String str){
        key =str;
    }

    public String value()
    {
        return this.key;
    }
}
@Entity
public class Runner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userID;
    private String name;
	private String password;
    private RUNNER_STATUS status=RUNNER_STATUS.AVAILABLE;
    private double deliveryFees;
    private int tripsCount=0;


    public int getTripsCount() {
        return tripsCount;
    }

    public void setTripsCount(int tripsCount) {
        this.tripsCount = tripsCount;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status.value();
    }

    public void setStatus(String statusStr) {
        if(statusStr=="Available")
        {
            this.status=RUNNER_STATUS.AVAILABLE;
        }
        if(statusStr=="Busy")
        {
            this.status=RUNNER_STATUS.BUSY;
        }
    }

    public double getDeliveryFees() {
        return deliveryFees;
    }

    public void setDeliveryFees(double deliveryFees) {
        this.deliveryFees = deliveryFees;
    }

    



    
}
