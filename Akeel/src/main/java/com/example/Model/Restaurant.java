package com.example.Model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int restaurantID;
	private String name;
	private int OwnerID;
	// private List<Meal> meals;
	
	Restaurant(){}
	Restaurant(String name,int OwnerID){
		this.setName(name); this.setOwnerID(OwnerID);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getOwnerID() {
		return OwnerID;
	}
	public void setOwnerID(int ownerID) {
		OwnerID = ownerID;
	}
}
