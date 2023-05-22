package com.example.Services;

import java.io.InputStream;
import java.io.InputStreamReader;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
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
   

   
    
    @PermitAll
    @POST
    @Path("signup")
    public String signUp(Runner runner){
        em.persist(runner);
        String message = "Sign up was successful! Your ID is "+ runner.getUserID();
        return message;
    }

    @PermitAll
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

            return "Welcome back "+runner.getName();
        }
        else{
            return "Could not find user, either your ID or password are wrong";
        }
    } 

    @RolesAllowed("runner")
    @PUT
    @Path("deliveredorder/{id}")
    public String deliveredOrder(@PathParam("id") int id,InputStream input){

        JsonReader reader = Json.createReader(new InputStreamReader(input));
        JsonObject jsonInput = reader.readObject();
        int runnerId = Integer.parseInt(jsonInput.getString("runnerID"));
        Runner runner = em.find(Runner.class, runnerId);

        Order order =em.find(Order.class, id);
        if(order.getId()==id){
            order.setStatus(orderStatus.DELIVERED);
            runner.setStatus("Available");
            runner.setTripsCount(runner.getTripsCount()+1);
            return "order status:"+order.getStatus()+"\n runner status:"+runner.getStatus();
        }
        else
        {
            return"invalid order";
        }

        

       

    }

    @PermitAll
    @GET
    @Path("trips/{id}")
    public int getTripsCount(@PathParam("id") int id){
        Runner runner = em.find(Runner.class, id);
        return runner.getTripsCount();
        
    }
  
}
