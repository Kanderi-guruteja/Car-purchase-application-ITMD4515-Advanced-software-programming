/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package edu.iit.sat.itmd4515.gkanderi.domain;

import jakarta.validation.constraints.NotNull;

/**
 * Enum representing the type of a car.
 */
@NotNull
public enum CarType {
    PETROL("Petrol"),
    DIESEL("Diesel"),
    ELECTRIC("Electric"),
    HYBRID("Hybrid");

    private String label;

    private CarType(String label) {
        this.label = label;
    }

    /**
     * Get the label associated with the car type.
     *
     * @return the label associated with the car type
     */
    public String getLabel() {
        return label;
    }

    /**
     * Get an array of all car types for form usage.
     *
     * @return an array of all car types for form usage
     */
    public CarType[] getAllCarTypesForForm() {
        return CarType.values();
    }
}
