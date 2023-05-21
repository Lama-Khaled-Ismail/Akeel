package com.example.Model;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int restaurantID;
	private String name;
	
    @ManyToOne
    @JoinColumn(name ="rests")
	private RestaurantOwner owner;
	@OneToMany(mappedBy = "fk_restaurantId",fetch = FetchType.LAZY)
	private List<Meal> meals ;
	
	@OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY)
	private Set<Order> orders;
	
	
	public Set<Order> getOrders() {
		return orders;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Meal> getMeals() {
		return meals;
	}
	public void setMeals(List<Meal> meals) {
		this.meals = new ArrayList<Meal>(meals);
	}
	public RestaurantOwner getOwnerID() {
		return owner;
	}
	public void setOwnerID(RestaurantOwner owner) {
		this.owner = owner;
	}
}
