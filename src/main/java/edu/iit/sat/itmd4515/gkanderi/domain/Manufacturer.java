package edu.iit.sat.itmd4515.gkanderi.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MANUFACTURER_ID")
    private Long id;

    @Column(name = "MANUFACTURER_EMAIL")
    private String email;

    @Column(name = "MANUFACTURER_NAME")
    private String name;

    @Column(name = "MANUFACTURER_MAKEDATE")
    private LocalDate makeDate;

    @OneToMany(mappedBy = "manufacturer")
    private List<Appointment> appointments = new ArrayList<>();
    
      public void addCar(Car car) {
        if (!this.cars.contains(car)) {
            this.cars.add(car);
            car.getManufacturer().add(this);
        }
    }

    public void removeCar(Car car) {
        if (this.cars.contains(car)) {
            this.cars.remove(car);
            car.getManufacturer().remove(this);
        }
    }

    @ManyToMany
    @JoinTable(name = "MANUFACTURER_CARS",
            joinColumns = @JoinColumn(name = "MANUFACTURER_ID"),
            inverseJoinColumns = @JoinColumn(name= "CAR_ID"))
    private List<Car> cars = new ArrayList<>();
    
    @ManyToOne
    @JoinColumn(name = "LEASINGOFFICE_ID")
    private Leasingoffice leasingoffice;
    
    public Manufacturer() {
    }

    public Manufacturer(String email, String name, LocalDate makeDate) {
        this.email = email;
        this.name = name;
        this.makeDate = makeDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getMakeDate() {
        return makeDate;
    }

    public void setMakeDate(LocalDate makeDate) {
        this.makeDate = makeDate;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public Leasingoffice getLeasingoffice() {
        return leasingoffice;
    }

    public void setLeasingoffice(Leasingoffice leasingoffice) {
        this.leasingoffice = leasingoffice;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final Manufacturer other = (Manufacturer) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Manufacturer{" + "id=" + id + ", email=" + email + ", name=" + name + ", makeDate=" + makeDate + '}';
    }

}
