/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package edu.iit.sat.itmd4515.gkanderi.domain;

import jakarta.validation.constraints.NotNull;

/**
 *
 * @author 18722
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

    public String getLabel() {
        return label;
    }

    public CarType[] getAllCarTypesForForm() {
        return CarType.values();
    }
}
