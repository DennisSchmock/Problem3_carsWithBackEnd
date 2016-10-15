/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Car;
import java.util.Date;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Dennis
 */
public class FacadeTester {
      public static  EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
       public static CarFacade cf = new CarFacade(emf);
       
       public static void main(String[] args) {
           Date date = new Date();
           Car car = new Car(123, date, "adf", "adf", "adf", 2222);
           Car car1 = new Car(223, date, "adf", "adf", "adf", 2222);
           Car car2 = new Car(323, date, "adf", "adf", "adf", 2222);
        cf.addCar(car);
        cf.addCar(car1);
        cf.addCar(car2);
    }

}
