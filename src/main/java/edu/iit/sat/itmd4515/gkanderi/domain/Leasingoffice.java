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
 *
 * @author 18722
 */
@Entity
@XmlRootElement
@NamedQuery(name = "Leasingoffice.findAll", query = "SELECT l FROM Leasingoffice l")
public class Leasingoffice extends AbstractEntity {

    @PersistenceContext
    private EntityManager entityManager;

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

    public String getLeasingofficeName() {
        return leasingofficeName;
    }

    public Leasingoffice() {
    }

    public Leasingoffice(String leasingofficeName) {
        this.leasingofficeName = leasingofficeName;
    }

    public List<Salesstaff> getSalesstaffList() {
        return salesstaffList;
    }

    public void setSalesstaffList(List<Salesstaff> salesstaffList) {
        this.salesstaffList = salesstaffList;
    }

    public void addSalesstaff(Salesstaff salesstaff) {
        salesstaff.setLeasingoffice(this);
    }

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
