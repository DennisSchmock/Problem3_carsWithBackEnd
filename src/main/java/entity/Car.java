/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Dennis
 */
@Entity
public class Car implements Serializable {

    private int year;
    
    @Temporal(TemporalType.DATE)
    private Date registered;
    
    private String make;
    private String model;
    private String description;
    private double price;

            
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Car() {
    }

    
    public Car(int year, Date registered, String make, String model, String description, double price) {
        this.year = year;
        this.registered = registered;
        this.make = make;
        this.model = model;
        this.description = description;
        this.price = price;
    }

    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
    /**
     * @return the model_year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param model_year the model_year to set
     */
    public void setYear(int model_year) {
        this.year = year;
    }

    /**
     * @return the registered
     */
    public Date getRegistered() {
        return registered;
    }

    /**
     * @param registered the registered to set
     */
    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    /**
     * @return the make
     */
    public String getMake() {
        return make;
    }

    /**
     * @param make the make to set
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

}
