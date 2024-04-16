/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.gkanderi.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Version;
import java.time.LocalDateTime;

/**
 *
 * @author 18722
 */
@MappedSuperclass
public class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "ID")
    protected Long id;

    @Version
    private Long version;

    private LocalDateTime createdTimestamp;

    private LocalDateTime modifiedTimestamp;

    @PrePersist
    public void initializeCreatedTimestamp() {
        this.createdTimestamp = LocalDateTime.now();

    }

    @PreUpdate
    public void initializeModifiedTimestamp() {
        this.modifiedTimestamp = LocalDateTime.now();

    }

    /**
     * Get the value of modifiedTimestamp
     *
     * @return the value of modifiedTimestamp
     */
    public LocalDateTime getModifiedTimestamp() {
        return modifiedTimestamp;
    }

    /**
     * Set the value of modifiedTimestamp
     *
     * @param modifiedTimestamp new value of modifiedTimestamp
     */
    public void setModifiedTimestamp(LocalDateTime modifiedTimestamp) {
        this.modifiedTimestamp = modifiedTimestamp;
    }

    /**
     * Get the value of createdTimestamp
     *
     * @return the value of createdTimestamp
     */
    public LocalDateTime getCreatedTimestamp() {
        return createdTimestamp;
    }

    /**
     * Set the value of createdTimestamp
     *
     * @param createdTimestamp new value of createdTimestamp
     */
    public void setCreatedTimestamp(LocalDateTime createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    /**
     * Get the value of version
     *
     * @return the value of version
     */
    public Long getVersion() {
        return version;
    }

    /**
     * Set the value of version
     *
     * @param version new value of version
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
