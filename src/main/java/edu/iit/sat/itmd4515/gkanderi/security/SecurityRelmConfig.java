package edu.iit.sat.itmd4515.gkanderi.security;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;

/**
 *
 * @author 18722
 */
@Named
@ApplicationScoped
@DatabaseIdentityStoreDefinition(dataSourceLookup = "java:app/jdbc/itmd4515DS",
        callerQuery = "select PASSWORD from SEC_USER where USERNAME = ?",
        groupsQuery = "select GROUPNAME from SEC_USER_GROUPS where USERNAME = ?")
public class SecurityRelmConfig {
    
}
