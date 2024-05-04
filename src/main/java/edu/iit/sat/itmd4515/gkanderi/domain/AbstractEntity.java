/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.gkanderi.domain;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Version;
import java.time.LocalDateTime;

/**
 * The AbstractEntity class serves as a base class for all entities in the system.
 * It defines common fields and behavior shared by all entities.
 */
@MappedSuperclass
public class AbstractEntity {

    /**
     * The unique identifier of the entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    protected Long id;

    /**
     * The version number of the entity for optimistic locking.
     */
    @Version
    private Long version;

    /**
     * The timestamp when the entity was created.
     */
    private LocalDateTime createdTimestamp;

    /**
     * The timestamp when the entity was last modified.
     */
    private LocalDateTime modifiedTimestamp;

    /**
     * Initializes the createdTimestamp before persisting the entity.
     */
    @PrePersist
    public void initializeCreatedTimestamp() {
        this.createdTimestamp = LocalDateTime.now();
    }

    /**
     * Initializes the modifiedTimestamp before updating the entity.
     */
    @PreUpdate
    public void initializeModifiedTimestamp() {
        this.modifiedTimestamp = LocalDateTime.now();
    }

    /**
     * Get the value of modifiedTimestamp.
     *
     * @return the value of modifiedTimestamp
     */
    public LocalDateTime getModifiedTimestamp() {
        return modifiedTimestamp;
    }

    /**
     * Set the value of modifiedTimestamp.
     *
     * @param modifiedTimestamp the new value of modifiedTimestamp
     */
    public void setModifiedTimestamp(LocalDateTime modifiedTimestamp) {
        this.modifiedTimestamp = modifiedTimestamp;
    }

    /**
     * Get the value of createdTimestamp.
     *
     * @return the value of createdTimestamp
     */
    public LocalDateTime getCreatedTimestamp() {
        return createdTimestamp;
    }

    /**
     * Set the value of createdTimestamp.
     *
     * @param createdTimestamp the new value of createdTimestamp
     */
    public void setCreatedTimestamp(LocalDateTime createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    /**
     * Get the value of version.
     *
     * @return the value of version
     */
    public Long getVersion() {
        return version;
    }

    /**
     * Set the value of version.
     *
     * @param version the new value of version
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    /**
     * Get the ID of the entity.
     *
     * @return the ID of the entity
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the ID of the entity.
     *
     * @param id the new ID of the entity
     */
    public void setId(Long id) {
        this.id = id;
    }
}
