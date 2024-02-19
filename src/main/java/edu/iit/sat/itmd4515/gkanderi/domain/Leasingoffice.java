/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.gkanderi.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Objects;

/**
 *
 * @author 18722
 */
@Entity
public class Leasingoffice {

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.Id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Leasingoffice other = (Leasingoffice) obj;
        
        if( this.Id == null || other.Id == null){
             return false;
         }
        return Objects.equals(this.Id, other.Id);
    }

    @Override
    public String toString() {
        return "Leasingoffice{" + "Id=" + Id + ", leasingofficeName=" + leasingofficeName + '}';
    }

    public Leasingoffice() {
    }

    public Leasingoffice(String leasingofficeName) {
        this.leasingofficeName = leasingofficeName;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LEASINGOFFICE_ID")
    private Long Id;
    
    @Column(name = "LEASINGOFFICE_NAME")
    private String leasingofficeName;

    /**
     * Get the value of leasingofficeName
     *
     * @return the value of leasingofficeName
     */
    public String getLeasingofficeName() {
        return leasingofficeName;
    }

    /**
     * Set the value of leasingofficeName
     *
     * @param leasingofficeName new value of leasingofficeName
     */
    public void setLeasingofficeName(String leasingofficeName) {
        this.leasingofficeName = leasingofficeName;
    }

    
    
    /**
     * Get the value of Id
     *
     * @return the value of Id
     */
    public Long getId() {
        return Id;
    }

//values 

    /**
     * Set the value of Id
     *
     * @param Id new value of Id
     */
    public void setId(Long Id) {
        this.Id = Id;
    }

    
    
}
