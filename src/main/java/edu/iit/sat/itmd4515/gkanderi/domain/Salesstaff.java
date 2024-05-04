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
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import edu.iit.sat.itmd4515.gkanderi.security.User;

/**
 * Represents a sales staff member.
 * 
 * @author 18722
 */
@NamedQuery(name = "Salesstaff.findAll", query = "select s FROM Salesstaff s")
@Entity
public class Salesstaff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SALES_ID")
    private Long id;

    @Column(name = "SALES_STAFF")
    private String name;

    @OneToOne
    private User user;

    @OneToOne
    private Manufacturer manufacturer;

    // New field for bi-directional relationship with Leasingoffice
    @OneToOne
    private Leasingoffice leasingoffice;

    @OneToMany(mappedBy = "salesstaff")
    private List<Appointment> appointments = new ArrayList<>();

    /**
     * Get the user associated with the sales staff.
     *
     * @return the user associated with the sales staff
     */
    public User getUser() {
        return user;
    }

    /**
     * Set the user associated with the sales staff.
     *
     * @param user the user associated with the sales staff
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Get the list of appointments associated with the sales staff.
     *
     * @return the list of appointments associated with the sales staff
     */
    public List<Appointment> getAppointments() {
        return appointments;
    }

    /**
     * Set the list of appointments associated with the sales staff.
     *
     * @param appointments the list of appointments associated with the sales staff
     */
    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    /**
     * Default constructor for the Salesstaff class.
     */
    public Salesstaff() {
    }

    /**
     * Get the ID of the sales staff.
     *
     * @return the ID of the sales staff
     */
    public Long getId() {
        return id;
    }

    /**
     * Constructor for the Salesstaff class.
     *
     * @param name the name of the sales staff
     */
    public Salesstaff(String name) {
        this.name = name;
    }

    /**
     * Get the leasing office associated with the sales staff.
     *
     * @return the leasing office associated with the sales staff
     */
    public Leasingoffice getLeasingoffice() {
        return leasingoffice;
    }

    /**
     * Set the leasing office associated with the sales staff.
     *
     * @param leasingoffice the leasing office associated with the sales staff
     */
    public void setLeasingoffice(Leasingoffice leasingoffice) {
        this.leasingoffice = leasingoffice;
    }

    /**
     * Generate a hash code for the sales staff.
     *
     * @return the hash code generated for the sales staff
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    /**
     * Check if the given object is equal to this sales staff.
     *
     * @param o the object to compare with this sales staff
     * @return true if the given object is equal to this sales staff, otherwise false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Salesstaff that = (Salesstaff) o;
        return Objects.equals(id, that.id)
                && Objects.equals(name, that.name);
    }

    /**
     * Get a string representation of the sales staff.
     *
     * @return a string representation of the sales staff
     */
    @Override
    public String toString() {
        return "Salesstaff{"
                + "id=" + id
                + ", name='" + name + '\''
                + '}';
    }

}
