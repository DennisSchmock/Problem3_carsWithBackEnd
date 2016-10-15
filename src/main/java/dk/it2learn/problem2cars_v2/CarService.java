/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.it2learn.problem2cars_v2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Car;
import facade.CarFacade;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Dennis
 */
@Path("car")
public class CarService {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    CarFacade cf = new CarFacade(emf);
    private static final Gson gson = new GsonBuilder().
            setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").
            setPrettyPrinting().create();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CarService
     */
    public CarService() {
    }

    /**
     * Retrieves representation of an instance of
     * dk.it2learn.problem2cars_v2.CarService
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getCars() {
        return gson.toJson(cf.getCars());

    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getCar(@PathParam("id") int id) {
        return gson.toJson(cf.getCar(id));

    }

    /**
     * PUT method for updating or creating an instance of CarService
     *
     * @param content representation for the resource
     * @return
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String editCar(String content) {
        Car car = gson.fromJson(content, Car.class);
        cf.editCar(car);
        return gson.toJson(car);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String addCar(String content) {
                

        Car car = gson.fromJson(content, Car.class);
        System.out.println("Got car: "+car);
        cf.addCar(car);
        return gson.toJson(car);
    }
    
    @Path("/{id}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public String deleteCar(@PathParam("id") int id) {
        
        Car car = cf.deleteCar(id);
        return gson.toJson(car);
    }

}
