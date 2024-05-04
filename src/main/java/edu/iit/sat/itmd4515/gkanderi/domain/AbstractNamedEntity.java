/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.gkanderi.domain;

import jakarta.persistence.MappedSuperclass;

/**
 * The AbstractNamedEntity class extends AbstractEntity and represents entities
 * with a name attribute.
 */
@MappedSuperclass
public class AbstractNamedEntity extends AbstractEntity {

    /**
     * The name of the entity.
     */
    protected String name;

    /**
     * Get the name of the entity.
     *
     * @return the name of the entity
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the entity.
     *
     * @param name the new name of the entity
     */
    public void setName(String name) {
        this.name = name;
    }
}
