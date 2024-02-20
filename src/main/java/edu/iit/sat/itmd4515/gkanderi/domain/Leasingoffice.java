package edu.iit.sat.itmd4515.gkanderi.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import java.util.Objects;

@Entity
public class Leasingoffice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LEASINGOFFICE_ID")
    private Long id;

    @Column(name = "LEASINGOFFICE_NAME")
    private String leasingofficeName;
    
    @OneToOne(mappedBy = "leasingoffice")
    private Manufacturer manufacturer;

    public Leasingoffice() {
    }

    public Leasingoffice(String leasingofficeName) {
        this.leasingofficeName = leasingofficeName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLeasingofficeName() {
        return leasingofficeName;
    }

    public void setLeasingofficeName(String leasingofficeName) {
        this.leasingofficeName = leasingofficeName;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Leasingoffice{" + "id=" + id + ", leasingofficeName=" + leasingofficeName + '}';
    }

}
