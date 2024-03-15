/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import edu.iit.sat.itmd4515.gkanderi.domain.Car;
import edu.iit.sat.itmd4515.gkanderi.domain.CarType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.time.LocalDate;
/**
 *
 * @author 18722
 */
public class Lab4Demo {
    public static void main (String ... args){
    
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("itmd4515testPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        Car c1 =new Car("bmw", LocalDate.of(2022, 12, 10),CarType.Petrol);
        System.out.println("Example: Car.toString() Before transaction:"+c1.toString());
        
        tx.begin();
        em.persist(c1);
        tx.commit();
        
        System.out.println("Example: Car.toString() after transaction:"+c1.toString());
        
        em.close();
        emf.close();
    }
    
}
