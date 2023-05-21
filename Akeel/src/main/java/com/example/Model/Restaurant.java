package com.example.Model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int restaurantID;
	private String name;
	
	@OneToOne(mappedBy = "rest")
	private RestaurantOwner owner;
	@OneToMany(mappedBy = "fk_restaurantId",fetch = FetchType.LAZY)
	private List<Meal> meals;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public RestaurantOwner getOwnerID() {
		return owner;
	}
	public void setOwnerID(RestaurantOwner owner) {
		this.owner = owner;
	}
}
