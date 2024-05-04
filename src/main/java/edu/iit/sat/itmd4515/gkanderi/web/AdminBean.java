package edu.iit.sat.itmd4515.gkanderi.web;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import edu.iit.sat.itmd4515.gkanderi.security.User;
import edu.iit.sat.itmd4515.gkanderi.security.UserService;

/**
 *
 * @author 18722
 */
@Named
@RequestScoped
public class AdminBean {
    
    @Inject
    private UserService userService;
    
    private User newUser;
    private boolean showCreateUserForm = false; // Initially hide the form
    
    /**
     *
     */
    public AdminBean() {
        newUser = new User();
    }
    
    /**
     *
     */
    public void createUser() {
        // Logic to create a new user with the provided details
        try {
            userService.createUser(newUser);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "User created successfully");
            FacesContext.getCurrentInstance().addMessage(null, message);
            // Reset newUser for next user creation
            newUser = new User();
        } catch (Exception e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Failed to create user: " + e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    
    // Method to toggle the display of the create user form

    /**
     *
     */
    public void toggleCreateUserForm() {
        showCreateUserForm = !showCreateUserForm;
    }

    // Getters and setters

    /**
     *
     * @return
     */
    
    public User getNewUser() {
        return newUser;
    }

    /**
     *
     * @param newUser
     */
    public void setNewUser(User newUser) {
        this.newUser = newUser;
    }
    
    /**
     *
     * @return
     */
    public boolean isShowCreateUserForm() {
        return showCreateUserForm;
    }

    /**
     *
     * @param showCreateUserForm
     */
    public void setShowCreateUserForm(boolean showCreateUserForm) {
        this.showCreateUserForm = showCreateUserForm;
    }
}
