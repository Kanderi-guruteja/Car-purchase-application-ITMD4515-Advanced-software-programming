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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author 18722
 */
@Entity
public class Salesstaff {
    
    /**
     * one to many : many to one bidirectional relationship
     * manufacturer is the inverse (non-owning side)
     */
    @OneToMany(mappedBy = "salesstaff")
    private List<Appointment> appts = new ArrayList<>();
    private Leasingoffice leasingoffice;

    /**
     * Get the value of appts
     *
     * @return the value of appts
     */
    public List<Appointment> getAppts() {
        return appts;
    }

    /**
     * Set the value of appts
     *
     * @param appts new value of appts
     */
    public void setAppts(List<Appointment> appts) {
        this.appts = appts;
    }


    public Salesstaff() {
    }

    public Salesstaff(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Salesstaff{" + "Id=" + Id + ", name=" + name + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.Id);
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
        final Salesstaff other = (Salesstaff) obj;
        
        if (this.Id == null || other.Id == null) {
            return false;
        }
        return Objects.equals(this.Id, other.Id);
    }
    
    @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SALES_ID")
    private Long Id;
    
    
    @Column(name = "SALES_STAFF")
    private String name;
    /**
     * 1:1 unidirectional relationship between sales-staff and Leasing-office
     * sales-staff is the manufacturer
     */
    @OneToOne
    @JoinColumn(name = "MANUFACTURER_ID")
    private Manufacturer manufacturer;

    /**
     * Get the value of manufacturer
     *
     * @return the value of manufacturer
     */
    public Manufacturer getManufacturer() {
        return manufacturer;
    }
     public Leasingoffice getLeasingoffice() {
        return leasingoffice;
    }
    /**
     * Set the value of manufacturer
     *
     * @param manufacturer new value of manufacturer
     */
    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }


    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the value of Id
     *
     * @return the value of Id
     */
    public Long getId() {
        return Id;
    }

    /**
     * Set the value of Id
     *
     * @param Id new value of Id
     */
    public void setId(Long Id) {
        this.Id = Id;
    }

  public void setLeasingoffice(Leasingoffice leasingoffice) {
    this.leasingoffice = leasingoffice;
    
    

   
}
}

    
//}
