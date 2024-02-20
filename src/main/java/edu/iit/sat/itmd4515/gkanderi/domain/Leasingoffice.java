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
public class Leasingoffice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LEASINGOFFICE_ID")
    private Long id;
    
    public Long getId() {
    return id;
}

    @Column(name = "LEASINGOFFICE_NAME")
    private String leasingofficeName;

    @OneToOne(mappedBy = "leasingoffice")
    private Manufacturer manufacturer;
    
    
    // New field for bi-directional relationship with Salesstaff
    @OneToOne(mappedBy = "leasingoffice")
    private Salesstaff salesstaff;

    // New field for one-to-many relationship with Salesstaff
    @OneToMany(mappedBy = "leasingoffice")
    private List<Salesstaff> salesstaffList = new ArrayList<>();

    public String getLeasingofficeName() {
        return leasingofficeName;
    }
    // Default constructor
    public Leasingoffice() {
    }

    // Constructor with parameters
    public Leasingoffice(String leasingofficeName) {
        this.leasingofficeName = leasingofficeName;
    }

    // Getters and setters

    public List<Salesstaff> getSalesstaffList() {
        return salesstaffList;
    }

    public void setSalesstaffList(List<Salesstaff> salesstaffList) {
        this.salesstaffList = salesstaffList;
    }
    
    public void addSalesstaff(Salesstaff salesstaff) {
        salesstaff.setLeasingoffice(this);
    }

    // Getters and setters

    // hashCode, equals, and toString methods
    @Override
    public int hashCode() {
        return Objects.hash(id, leasingofficeName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Leasingoffice that = (Leasingoffice) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(leasingofficeName, that.leasingofficeName);
    }

    @Override
    public String toString() {
        return "Leasingoffice{" +
                "id=" + id +
                ", leasingofficeName='" + leasingofficeName + '\'' +
                '}';
    }
}
