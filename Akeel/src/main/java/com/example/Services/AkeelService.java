package com.example.Services;


import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import javax.json.*;
import javax.annotation.Generated;
import javax.ejb.PostActivate;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.Model.Meal;
import com.example.Model.Order;
import com.example.Model.Restaurant;
import com.example.Model.RestaurantOwner;
import com.example.Model.orderStatus;



@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/Owner")
public class AkeelService{
	
	
	@PersistenceContext(unitName = "Akeel")
	private EntityManager em;
	

	@GET
	@Path("add")
	public String getName(){
		return "Hello";
	}

	@GET
	@Path("login")
	public JsonObject login(RestaurantOwner owner){
		int id =  owner.getUserID();
		JsonObjectBuilder objectBuilder = Json.createObjectBuilder();

		TypedQuery<RestaurantOwner> query=em.createQuery(
			"SELECT r from RestaurantOwner r where r.userID >: ID",RestaurantOwner.class);
		query.setParameter("ID", id);

		if(	query.getSingleResult().getPassword().equals(owner.getPassword())){
			return objectBuilder.add("WELCOME USER,", owner.getName()).build();
		} 
		return objectBuilder.add("LOGIN FAILED.TRY AGAIN",owner.getName()).build();
	}

	@POST
	@Path("signup")
	public JsonObject signUp(RestaurantOwner owner){
		em.persist(owner);
		// Create a JsonReader object to read the JSON input from the InputStream
/*		JsonReader reader = Json.createReader(new InputStreamReader(input));
		// Parse the JSON input to a JsonObject
        JsonObject jsonInput = reader.readObject();
        
        owner.setName(jsonInput.R
        // owner.setRest(rest);
 */
        JsonObjectBuilder objectBuilder = Json.createObjectBuilder()
        		.add("SIGN UP SUCCESSFUL\nUSERNAME ", owner.getName())
        		.add("ID", owner.getUserID());
        // Create a JSON object with the builder
        JsonObject jsonOutput = objectBuilder.build();

        return jsonOutput;
	}
	@POST
	@Path("addRest/{id}")
	public String addRestaurant(@PathParam("id") String id,Restaurant rest){
		int ownerid = Integer.parseInt(id);
		RestaurantOwner owner = em.find(RestaurantOwner.class,ownerid );
		rest.setOwnerID(owner);
		String list=""; int i=1;
		
		for(Meal meal:rest.getMeals()){ 
			list+= i+"- "+meal.getName()+'\t'+meal.getPrice()+'\n';i++;
		}

		em.persist(rest);
		em.merge(owner);	//TODO

		return rest.getName()+"'S MENU\n"+(list);
	}

	@GET
	@Path("getRest/{id}")
	public String getRestaurant (@PathParam("id") String id){
		int restid = Integer.parseInt(id);
		Restaurant rest = em.find(Restaurant.class, restid);
		String list=""; int i=0;
		for(Meal meal : rest.getMeals()){ 
			list+= ++i+"- "+meal.getName()+'\t'+meal.getPrice()+'\n'; 
		}
		return rest.getName()+"'S MENU\n"+list+rest.getMeals().size();
	}

	@POST
	@Path("getReport/{id}")
	public String getReport ( @PathParam("id") String id){
		int restid = Integer.parseInt(id);
		Restaurant rest = em.find(Restaurant.class, restid);
		double revenue,comp_orders,canceled_orders;
		revenue = comp_orders = canceled_orders =0;
		
		for(Order order:rest.getOrders()){
			if(order.getStatus().equals(orderStatus.DELIVERED) ){
					revenue+= order.getTotal(); 
					comp_orders++;}
			if(order.getStatus().equals(orderStatus.DELIVERED) )
					canceled_orders++;
		}
	return "REVENUE:\n"+revenue+"\nCOMPLETED ORDERS\n"+comp_orders+"\nCANCELLED ORDERS\n"+canceled_orders;
	}

	@DELETE
	@Path("EditMenu/{restID}/{mealID}")
	public void deleteMeal( @PathParam("restID") String restID, @PathParam("mealID") String mealID){
		int restid = Integer.parseInt(restID);
		int mealid = Integer.parseInt(mealID);
		Restaurant rest = em.find(Restaurant.class, restid);
		Meal meal = rest.getMeals().get(mealid); 
		em.remove(meal);		
	}

	@PUT
	@Path("EditMenu/{restID}/{mealID}")
	public void deleteMeal( @PathParam("restID") String restID, @PathParam("mealID") String mealID,Meal newMeal){
		int restid = Integer.parseInt(restID);
		int mealid = Integer.parseInt(mealID);
		Restaurant rest = em.find(Restaurant.class, restid);
		Meal meal = rest.getMeals().get(mealid);
		em.remove(meal);
		em.persist(newMeal); 	
	}

}