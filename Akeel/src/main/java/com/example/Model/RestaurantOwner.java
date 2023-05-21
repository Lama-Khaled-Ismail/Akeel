package com.example.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class RestaurantOwner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userID;
	private String name;
	private String password;
    
	@OneToMany(mappedBy = "owner",fetch = FetchType.LAZY)
	private List<Restaurant> rests= new ArrayList<Restaurant>();
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

	public List<Restaurant> getRests() {
		return rests;
	}

	
	public void addRestaurant(Restaurant rest) {
		rests.add(rest);
	}
/* 	public Role getRole() {
		return role;
	}

    
	

*/
	

}
