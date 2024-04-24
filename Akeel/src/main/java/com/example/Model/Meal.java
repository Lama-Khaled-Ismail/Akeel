package com.example.Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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
	private String mealName;
	private float price;
	
	@ManyToOne
	@JoinColumn(name="meals")
	private Restaurant fk_restaurantId;
	
	public Restaurant getFk_restaurantId() {
		return fk_restaurantId;
	}
	public void setFk_restaurantId(Restaurant fk_restaurantId) {
		this.fk_restaurantId = fk_restaurantId;
	}
	
	@ManyToMany(mappedBy = "items",cascade = CascadeType.PERSIST)
	private Set<Order> ordersWithThisMeal=new HashSet<>();


	public Set<Order> getOrdersWithThisMeal() {
		return ordersWithThisMeal;
	}
	public void setOrdersWithThisMeal(Set<Order> ordersWithThisMeal) {
		this.ordersWithThisMeal = ordersWithThisMeal;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getName() {
		return mealName;
	}
	public void setName(String name) {
		this.mealName = name;
	}


}
   
