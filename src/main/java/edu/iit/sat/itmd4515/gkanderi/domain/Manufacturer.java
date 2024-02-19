package edu.iit.sat.itmd4515.gkanderi.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author 18722
 */
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
    private List<Appointment> appts = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "MANUFACTURER_CARS",
            joinColumns = @JoinColumn(name = "MANUFACTURER_ID"),
            inverseJoinColumns = @JoinColumn(name= "CAR_ID"))
    private List<Car> cars = new ArrayList<>();
    
     // Default constructor
    public Manufacturer() {
        
        }
    public void addCar(Car c){
        if(!this.cars.contains(c)){
        this.cars.add(c);
        }
        if(!c.getManufacturer().contains(this)){
        c.getManufacturer().add(this);
        }
        
    }
    
    public void removeCar(Car c){
        if(this.cars.contains(c)){
        this.cars.remove(c);
        }
        if(c.getManufacturer().contains(this)){
        c.getManufacturer().remove(this);
        }
        
    }

    // Updated parameterized constructor
    public Manufacturer(String email, String name, LocalDate makeDate) {
        this.email = email;
        this.name = name;
        this.makeDate = makeDate;
    }

    // Getters and setters for all fields

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

    public List<Appointment> getAppts() {
        return appts;
    }

    public void setAppts(List<Appointment> appts) {
        this.appts = appts;
    }

    public void addAppointment(Appointment appointment) {
        this.appts.add(appointment);
        appointment.setManufacturer(this);
    }

    public void removeAppointment(Appointment appointment) {
        this.appts.remove(appointment);
        appointment.setManufacturer(null);
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    /**
    public void addCar(Car car) {
        this.cars.add(car);
        car.getManufacturer().add(this);
    }
    **/
/**
    public void removeCar(Car car) {
        this.cars.remove(car);
        car.getManufacturer().remove(this);
    }
    **/

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

    // Other methods as needed
}
