/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.gkanderi.domain;


import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author 18722
 */
public class JPARelationshipTest extends AbstractJPATest{
    @Test
    public void uniDirectionalRelationshipTest(){
        Leasingoffice l = new Leasingoffice("Priority Car Leasing"); // Remove the extra space here   
        Salesstaff s = new Salesstaff("Priority salesstaff");
        s.setLeasingoffice(l);
        
        tx.begin();
        //first, persist the entity that owns the relationship
        em.persist(l);
        //after persisting the non owning entity, persist the owning one
        em.persist(s);
        tx.commit();
        
        //read back from database into a new instance, and assert
        Salesstaff readBackFromDatabase = em.find(Salesstaff.class, s.getId());
        assertNotNull(readBackFromDatabase.getLeasingoffice());
        assertEquals("Priority Car Leasing", readBackFromDatabase.getLeasingoffice().getLeasingofficeName().trim()); 
                //remember to clean the test data
                // i have not done it here

    
    }
    
    /**
     * Testing the Many to Many Bi-Directional relationship
     */
    @Test
    public void biDirectionalRelationshipTest(){
        
     Manufacturer m = new Manufacturer("Manufacturer@none.net", "Manufacturer Test",LocalDate.of(1980,2,10));
     Car c = new Car ("Mercedes Benz", LocalDate.of(2023, 1, 17), CarType.Petrol);
     
     //scenario #1
     
     // we create object instance and persist them , but  we do not set the
     //relationships. In other words, we fail  to manage both side (or even 
     //one side in this case ) of the relationship
     //what happens? The database is unaware of the relationship. No
        
    //scenario #2
    // we set the non-owning side, and we do not set the owning side.
    //what happens?//Nothing was set from teh owning side, therefore no 
    //data was inserted into then join tables despite being added to the 
    //inverse side.
    
    //c.getManufacturer().add(m);
    
    //scenario #3
    //Let's try the opposite.set the owning side but not the inverse side.
    //what happens?
    //the database was updated. HOWEVER.... when we explore some
    //application level navigation, what happens?
    //collection is populated, but inverse is not. I have failed to 
    //satisfy the JPA requirement to manage both sides of my rel.
    
   // m.getCars().add(c);
   
   //scenario #4
   
   //let's fo things both sides
   //what happens? works as expected. data exists in join table
   //and collections are populated in both sides of relationship
  // m.getCars().add(c);
  // c.getManufacturer().add(m);
   
   m.addCar(c);
    
    
    
     
        tx.begin();
        em.persist(c);
        em.persist(m);
        tx.commit();
        
        System.out.println("Navigating relationship from the owning side" + m.getCars().toString());
        System.out.println("Navigating relationship from the inverse side" +c.getManufacturer().toString());

       //we can assert based on the collection represnting the relationships 
       assertFalse(m.getCars().isEmpty());
       assertTrue(c.getManufacturer().size()==1);
       
       //remember to clean the test data
       
       tx.begin();
    //first , unset the relationships from  owning side 
       m.removeCar(c);
       
       // then, remove the non owning entity first
       em.remove(c);
       em.remove(m);
       tx.commit();
    }
    
}
