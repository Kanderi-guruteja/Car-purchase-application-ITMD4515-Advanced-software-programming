package edu.iit.sat.itmd4515.gkanderi.security;
import jakarta.inject.Inject;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.security.enterprise.identitystore.Pbkdf2PasswordHash;

/**
 *
 * @author 18722
 */
public class UserPasswordHash {
    
    @Inject private Pbkdf2PasswordHash hash;
    
    @PrePersist
    @PreUpdate
    private void hashPassword(User u){
        u.setPassword(hash.generate(u.getPassword().toCharArray()));
    }
}
