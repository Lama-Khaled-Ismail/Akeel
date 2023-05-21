package com.example.Model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userID;
	private String name;
	private String password;
    @OneToMany(mappedBy = "customerID", fetch = FetchType.LAZY)
    private Set<Order> orders;

    public Customer() {}

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

    

    
}
