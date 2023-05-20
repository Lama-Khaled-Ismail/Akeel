package com.example.Services;


import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import javax.json.*;
import javax.ejb.PostActivate;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.Model.RestaurantOwner;



@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/")
public class AkeelService{
	
	
	@PersistenceContext(unitName = "Akeel")
	private EntityManager em;
	

	@GET
	@Path("add")
	public String getName(){
		return "Hello";
	}

	@POST
	@Path("Owner")
	public JsonObject signUp(RestaurantOwner owner){
		em.persist(owner);
		// Create a JsonReader object to read the JSON input from the InputStream
/*		JsonReader reader = Json.createReader(new InputStreamReader(input));
		// Parse the JSON input to a JsonObject
        JsonObject jsonInput = reader.readObject();
        
        owner.setName(jsonInput.getString("name"));
		owner.setPassword(jsonInput.getString("password"));
        // Restaurant rest = (Restaurant)jsonInput.get("Restaurant");
        // System.out.print("Retaurant name: "+rest.getName());
        // owner.setRest(rest);
 */
        JsonObjectBuilder objectBuilder = Json.createObjectBuilder()
        		.add("USERNAME ", owner.getName())
        		.add("ID", owner.getUserID());
        		
        // Create a JSON object with the builder
        JsonObject jsonOutput = objectBuilder.build();

        return jsonOutput;
	}
	
	

}