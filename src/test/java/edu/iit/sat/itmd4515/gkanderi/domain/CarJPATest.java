/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.gkanderi.domain;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.time.LocalDate;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 *
 * @author 18722
 */


public class CarJPATest extends AbstractJPATest{

   

    @Test
    public void createTest() {
        // create a new entity
        Car c2 = new Car("merc", LocalDate.of(2022, 12, 10), CarType.Petrol);
        Car c3 = new Car("audi", LocalDate.of(2022, 12, 10), CarType.Diesel);

        tx.begin();
        em.persist(c2);
        tx.commit();
        
         tx.begin();
        em.persist(c3);
        tx.commit();
        
        
        Car readBackFromDatabaseForAssertion = em.find(Car.class, c2.getId());
        assertEquals(c2.getId(), readBackFromDatabaseForAssertion.getId());
        //clean up data before exiting the method
    }

    @Test
    public void readTest() {
         // read test case - you could follow the same design as your JDBC read test, but make sure you use JPA here
    
    String carNameToRead = "bmw"; // Replace with the actual name to read

    tx.begin();
    Car car = em.createQuery("SELECT c FROM Car c WHERE c.name = :name", Car.class)
                .setParameter("name", carNameToRead)
                .getSingleResult();
    tx.commit();

    Assertions.assertNotNull(car, "Car entity with name '" + carNameToRead + "' not found");
     System.out.println("Read entity details:");
    System.out.println("ID: " + car.getId());
    System.out.println("Name: " + car.getName());
    System.out.println("Buy Date: " + car.getBuyDate());
    System.out.println("Type: " + car.getType());
}

    @Test
    public void upadteTest() { 
        
        // working with the beforeEach sample data...
        Car c2 = em.createQuery("select c from Car c where c.name='merc'", Car.class).getSingleResult();
        LocalDate newBuyday = LocalDate.of(2023,10,01);
        //update something
        //write it back to DB
        // using the set methods in a tx updates the database for a managed entity
        tx.begin();
        c2.setBuyDate(newBuyday);
        tx.commit();
         // read it back from the database
           Car readBackFromDatabaseForAssertion = em.find(Car.class, c2.getId());
           
           // assert that it was successfully updated
           
         assertEquals(newBuyday, readBackFromDatabaseForAssertion.getBuyDate()); 
         
    }

    @Test
    public void deleteTest() { 
         // delete test case - you could follow the same design as your JDBC delete test, but make sure you use JPA here
          Car audi = em.createQuery("SELECT c FROM Car c WHERE c.name = :name", Car.class)
                .setParameter("name", "audi")
                .getResultList()
                .stream()
                .findFirst()
                .orElse(null);

        Assertions.assertNotNull(audi, "AUDI entity not found");

        tx.begin();
        em.remove(audi);
        tx.commit();

        // Verify that the entity is deleted
        Car deletedAudi = em.find(Car.class, audi.getId());
        Assertions.assertNull(deletedAudi, "AUDI entity still exists after deletion"); 
    }
    
    @Test
    public void uniDirectionalRelationshipTest(){
    
    
    }
    
    @Test
    public void biDirectionalRelationshipTest(){}
    

    
}
