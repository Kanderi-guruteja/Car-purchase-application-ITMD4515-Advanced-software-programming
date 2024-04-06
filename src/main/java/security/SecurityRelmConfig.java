/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package security;

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
        callerQuery="select PASSWORD from SEC_USER where USERNAME=?",
        groupsQuery="select GROUPNAME from SEC_USER_GROUP where USERNAME=?")
public class SecurityRelmConfig {
    
    
}
