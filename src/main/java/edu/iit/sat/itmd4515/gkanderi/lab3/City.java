package edu.iit.sat.itmd4515.gkanderi.lab3;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
public class City {

    @Id
    @NotNull
    @Positive
    private Integer ID;

    @NotBlank
    private String name;

    @NotBlank
    private String countryCode;

    public City() {
        // Default constructor required for JPA
    }

    public City(Integer ID, String name, String countryCode) {
        this.ID = ID;
        this.name = name;
        this.countryCode = countryCode;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public String toString() {
        return "City{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", countryCode='" + countryCode + '\'' +
                '}';
    }
}
