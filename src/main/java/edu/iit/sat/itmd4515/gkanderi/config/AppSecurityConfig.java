/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.gkanderi.config;

import jakarta.annotation.security.DeclareRoles;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;
import jakarta.security.enterprise.authentication.mechanism.http.LoginToContinue;

/**
 *
 * @author 18722
 */
@Named
@ApplicationScoped
@DeclareRoles({"ADMIN_ROLE","MANUFACTURER_ROLE","SALESSTAFF_ROLE"})
@CustomFormAuthenticationMechanismDefinition(
    loginToContinue = @LoginToContinue(
    loginPage = "/login.xhtml",
      errorPage ="/error.xhtml")

)
public class AppSecurityConfig {
    
    
    
    
    
}
