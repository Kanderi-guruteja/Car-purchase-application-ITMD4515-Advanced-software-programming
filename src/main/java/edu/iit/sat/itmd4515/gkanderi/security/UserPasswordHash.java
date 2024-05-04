package edu.iit.sat.itmd4515.gkanderi.security;

import jakarta.inject.Inject;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.security.enterprise.identitystore.Pbkdf2PasswordHash;

/**
 * This class is responsible for hashing user passwords before persisting or updating User entities.
 * It uses the Pbkdf2PasswordHash utility provided by Jakarta Security Enterprise.
 * 
 * @author 18722
 */
public class UserPasswordHash {

    @Inject
    private Pbkdf2PasswordHash hash;

    /**
     * Hashes the password before persisting a User entity.
     * 
     * @param u The User entity to hash the password for.
     */
    @PrePersist
    @PreUpdate
    private void hashPassword(User u) {
        u.setPassword(hash.generate(u.getPassword().toCharArray()));
    }
}
