package com.example.Services;

import java.io.InputStream;
import java.io.InputStreamReader;

import javax.ejb.Stateless;
import javax.json.Json;
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

import com.example.Model.Customer;

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


}
