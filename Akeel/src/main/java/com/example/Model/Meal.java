package com.example.Model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Meal {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mealID;
	private String name;
	private float price;
	@ManyToOne
	@JoinColumn(name="meals")
	private Restaurant fk_restaurantId;
	@ManyToMany(mappedBy = "items")
	private Set<Order> ordersWithThisMeal;


	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
   
