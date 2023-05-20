package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class RestaurantOwner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userID;
	private String name;
	private String password;
      //@OneToOne
	//@JoinColumn(name="restaurantID")
	//private Restaurant rest;
    //private Role role;
	
    //public RestaurantOwner(){ role = Role.OWNER;}
	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

/* 	public Role getRole() {
		return role;
	}

    
	public Restaurant getRest() {
		return rest;
	}

	public void setRest(Restaurant rest) {
		this.rest = rest;
	}

*/
	

}
