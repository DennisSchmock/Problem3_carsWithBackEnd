/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Car;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author Dennis
 */
public class CarFacade {

    private static EntityManagerFactory emf;

    public CarFacade(EntityManagerFactory emf) {
        CarFacade.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<Car> getCars() {
        List<Car> cars = new ArrayList();
        EntityManager em = emf.createEntityManager();
        try{
            Query q = em.createQuery("Select c from Car c");
            cars = q.getResultList();
        }finally{
            em.close();
        }
        
        return cars;
    }

    public Car getCar(int id) {
        EntityManager em = emf.createEntityManager();
        Car car = null;
        try {
            car = em.find(Car.class, id);
        } finally {
            em.close();
        }
        return car;

    }

    public Car addCar(Car car) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(car);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return car;

    }

    public Car editCar(Car car) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(car);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return car;
    }

    public Car deleteCar(int id) {
        EntityManager em = emf.createEntityManager();
        Car car = null;
        try {
           car = em.find(Car.class, id);
            em.getTransaction().begin();
            em.remove(car);
            em.getTransaction().commit();

        } finally {
            em.close();
        }
        return car;
    }
}
