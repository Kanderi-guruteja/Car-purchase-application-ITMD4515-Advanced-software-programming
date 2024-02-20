package edu.iit.sat.itmd4515.gkanderi.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Salesstaff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SALES_ID")
    private Long id;

    @Column(name = "SALES_STAFF")
    private String name;

    @OneToOne
    private Manufacturer manufacturer;

    // New field for bi-directional relationship with Leasingoffice
    @OneToOne
    private Leasingoffice leasingoffice;

    @OneToMany(mappedBy = "salesstaff")
    private List<Appointment> appts = new ArrayList<>();

    // Default constructor
    public Salesstaff() {
    }
     public Long getId() {
        return id;
    }

    // Constructor with parameters
    public Salesstaff(String name) {
        this.name = name;
    }
    
    public Leasingoffice getLeasingoffice() {
        return leasingoffice;
    }

    // Setter method for leasing office
    public void setLeasingoffice(Leasingoffice leasingoffice) {
        this.leasingoffice = leasingoffice;
    }

    // Getters and setters

    // hashCode, equals, and toString methods
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Salesstaff that = (Salesstaff) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name);
    }

    @Override
    public String toString() {
        return "Salesstaff{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
