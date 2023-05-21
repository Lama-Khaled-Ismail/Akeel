package com.example.Services;

import java.io.InputStream;
import java.io.InputStreamReader;

import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.Model.Order;
import com.example.Model.Runner;
import com.example.Model.orderStatus;

@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/runner")

public class RunnerService {

    @PersistenceContext(unitName = "Akeel")
	private EntityManager em;

    private Runner currentRunner; 
    
    @POST
    @Path("signup")
    public String signUp(Runner runner){
        em.persist(runner);
        currentRunner = runner;
        String message = "Sign up was successful! Your ID is "+ runner.getUserID();
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

        Runner runner = em.find(Runner.class, id);
        if (runner.getPassword().equals(pass)){
            currentRunner =runner;
            return "Welcome back "+runner.getName();
        }
        else{
            return "Could not find user, either your ID or password are wrong";
        }
    } 

    @PUT
    @Path("deliveredorder/{id}")
    public String deliveredOrder(@PathParam("id") int id){

        Order order =em.find(Order.class, id);
        if(order.getId()==1){
            order.setStatus(orderStatus.DELIVERED);
            currentRunner.setStatus("Available");
            currentRunner.setTripsCount(currentRunner.getTripsCount()+1);
        }

        return "ordered delivered";

    }

    @GET
    @Path("trips")
    public int getTripsCount(){
        return currentRunner.getTripsCount();
        
    }
  
}
