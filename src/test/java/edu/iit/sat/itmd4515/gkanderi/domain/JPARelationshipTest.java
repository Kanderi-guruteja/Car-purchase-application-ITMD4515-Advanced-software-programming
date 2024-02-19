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
        em.persist(l);
        em.persist(s);
        tx.commit();
        
        Salesstaff readBackFromDatabase = em.find(Salesstaff.class, s.getId());
        assertNotNull(readBackFromDatabase.getLeasingoffice());
        assertEquals("Priority Car Leasing", readBackFromDatabase.getLeasingoffice().getLeasingofficeName().trim()); 
                
    
    }
    
    /**
     * Testing the Many to Many Bi-Directional relationship
     */
    @Test
    public void biDirectionalRelationshipTest(){
        
     Manufacturer m = new Manufacturer("Manufacturer@none.net", "Manufacturer Test",LocalDate.of(1980,2,10));
     Car c = new Car ("Mercedes Benz", LocalDate.of(2023, 1, 17), CarType.Petrol);
     
     //scenario #1
     
        
    //scenario #2
 
    //c.getManufacturer().add(m);
    
    //scenario #3
   
   // m.getCars().add(c);
   
   //scenario #4
  
  // m.getCars().add(c);
  // c.getManufacturer().add(m);
   
   m.addCar(c);
        tx.begin();
        em.persist(c);
        em.persist(m);
        tx.commit();
        
        System.out.println("Navigating relationship from the owning side" + m.getCars().toString());
        System.out.println("Navigating relationship from the inverse side" +c.getManufacturer().toString());

       assertFalse(m.getCars().isEmpty());
       assertTrue(c.getManufacturer().size()==1);
       tx.begin();
       m.removeCar(c);
       em.remove(c);
       em.remove(m);
       tx.commit();
    }
    
}
