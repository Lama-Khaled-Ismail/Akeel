package com.example.Services;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.Model.*;

@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/customer")
public class CustomerService {
    
    @PersistenceContext(unitName = "Akeel")
	private EntityManager em;
    
    @POST
    @Path("signup")
    public String signUp(Customer customer){
        em.persist(customer);
        String message = "Sign up was successful! Your ID is "+ customer.getUserID();
        return message;
    }

    @POST
    @Path("login")
    public String logIn(InputStream input){
        
        // Create a JsonReader object to read the JSON input from the InputStream
        JsonReader reader = Json.createReader(new InputStreamReader(input));

        // Parse the JSON input to a JsonObject
        JsonObject jsonInput = reader.readObject();
        int id = Integer.parseInt(jsonInput.getString("id"));
        String pass = jsonInput.getString("password");

        Customer customer = em.find(Customer.class, id);
        if (customer.getPassword().equals(pass)){
            return "Welcome back "+customer.getName();
        }
        else{
            return "Could not find user, either your ID or password are wrong";
        }
    }

    @POST
    @Path("/add_order")
    public Order addOrder(InputStream input){
        //? should i make sure customer id exists in DB
        // Create a JsonReader object to read the JSON input from the InputStream
        JsonReader reader = Json.createReader(new InputStreamReader(input));

        // Parse the JSON input to a JsonObject
        JsonObject jsonInput = reader.readObject();
        int customerID = Integer.parseInt(jsonInput.getString("customerID"));
        Customer customer = em.find(Customer.class, customerID);
        Order order =  new Order();
        order.setCustomer(customer);
        order.setDateTime(java.time.LocalDateTime.now());
        int restID = Integer.parseInt(jsonInput.getString("restaurantID"));
        Restaurant rest = em.find(Restaurant.class, restID);
        JsonArray meals = jsonInput.getJsonArray("meals");
        int len = meals.size();
        List list =  new ArrayList<Meal>();
        for (int i = 0; i < len; i++){
            int x = Integer.parseInt(meals.getString(i));
            Meal meal = rest.getMeals().get(x-1);
            //list.add(meal);
            order.addMealItem(meal);
        }

        
        
        //em.persist(order);
        return order;
        
    }

    


}
