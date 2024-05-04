package edu.iit.sat.itmd4515.gkanderi.security;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;

/**
 * Configuration class for the security realm.
 * This class specifies the database identity store definition for authentication and authorization.
 * 
 * The database identity store definition includes:
 * - dataSourceLookup: the JNDI name of the data source
 * - callerQuery: the SQL query to retrieve the password of a user by username
 * - groupsQuery: the SQL query to retrieve the groups of a user by username
 * 
 * @author 18722
 */
@Named
@ApplicationScoped
@DatabaseIdentityStoreDefinition(
        dataSourceLookup = "java:app/jdbc/itmd4515DS",
        callerQuery = "select PASSWORD from SEC_USER where USERNAME = ?",
        groupsQuery = "select GROUPNAME from SEC_USER_GROUPS where USERNAME = ?"
)
public class SecurityRelmConfig {

}
