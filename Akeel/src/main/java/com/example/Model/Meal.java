package com.example.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Meal {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mealID;
	private String name;
	private float price;
	
	Meal(){}
	Meal(int mealID,String name, float price){
		this.mealID = mealID;
		this.name = name;
		this.price = price;
	}
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
   
