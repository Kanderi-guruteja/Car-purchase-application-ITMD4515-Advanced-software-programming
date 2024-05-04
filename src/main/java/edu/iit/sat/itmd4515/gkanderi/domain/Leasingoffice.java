/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.gkanderi.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PersistenceContext;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Entity class representing a leasing office.
 */
@Entity
@XmlRootElement
@NamedQuery(name = "Leasingoffice.findAll", query = "SELECT l FROM Leasingoffice l")
public class Leasingoffice extends AbstractEntity {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Creates a new leasing office.
     *
     * @param leasingoffice the leasing office to create
     */
    public void create(Leasingoffice leasingoffice) {
        entityManager.persist(leasingoffice);
    }

    @Column(name = "LEASINGOFFICENAME")
    private String leasingofficeName;

    @OneToOne(mappedBy = "leasingoffice")
    private Manufacturer manufacturer;

    @OneToOne(mappedBy = "leasingoffice")
    private Salesstaff salesstaff;

    @OneToMany(mappedBy = "leasingoffice")
    private List<Salesstaff> salesstaffList = new ArrayList<>();

    /**
     * Gets the name of the leasing office.
     *
     * @return the name of the leasing office
     */
    public String getLeasingofficeName() {
        return leasingofficeName;
    }

    /**
     * Constructs a new instance of the leasing office.
     */
    public Leasingoffice() {
    }

    /**
     * Constructs a new instance of the leasing office with the specified name.
     *
     * @param leasingofficeName the name of the leasing office
     */
    public Leasingoffice(String leasingofficeName) {
        this.leasingofficeName = leasingofficeName;
    }

    /**
     * Gets the list of sales staff associated with this leasing office.
     *
     * @return the list of sales staff associated with this leasing office
     */
    public List<Salesstaff> getSalesstaffList() {
        return salesstaffList;
    }

    /**
     * Sets the list of sales staff associated with this leasing office.
     *
     * @param salesstaffList the list of sales staff associated with this leasing office
     */
    public void setSalesstaffList(List<Salesstaff> salesstaffList) {
        this.salesstaffList = salesstaffList;
    }

    /**
     * Adds a sales staff to this leasing office.
     *
     * @param salesstaff the sales staff to add
     */
    public void addSalesstaff(Salesstaff salesstaff) {
        salesstaff.setLeasingoffice(this);
    }

    /**
     * Sets the name of the leasing office.
     *
     * @param leasingofficeName the name of the leasing office
     */
    public void setLeasingofficeName(String leasingofficeName) {
        this.leasingofficeName = leasingofficeName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, leasingofficeName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Leasingoffice that = (Leasingoffice) o;
        return Objects.equals(id, that.id)
                && Objects.equals(leasingofficeName, that.leasingofficeName);
    }

    @Override
    public String toString() {
        return "Leasingoffice{"
                + "id=" + id
                + ", leasingofficeName='" + leasingofficeName + '\''
                + '}';
    }
}
