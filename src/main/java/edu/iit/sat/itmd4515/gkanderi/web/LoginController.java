package edu.iit.sat.itmd4515.gkanderi.web;

import edu.iit.sat.itmd4515.gkanderi.security.GroupService;
import edu.iit.sat.itmd4515.gkanderi.security.User;
import edu.iit.sat.itmd4515.gkanderi.security.UserService;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.security.enterprise.AuthenticationStatus;
import jakarta.security.enterprise.SecurityContext;
import jakarta.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import jakarta.security.enterprise.credential.Credential;
import jakarta.security.enterprise.credential.Password;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The LoginController class manages user login functionality in the web application.
 * It handles user authentication, registration, and logout.
 * This controller is responsible for interacting with the SecurityContext to perform authentication operations.
 * 
 * @author 18722
 */
@Named
@RequestScoped
public class LoginController {

    private static final Logger LOG = Logger.getLogger(LoginController.class.getName());

    @Inject
    SecurityContext securityContext;

    @Inject
    private GroupService groupService;

    @Inject
    private UserService userService;

    @Inject
    FacesContext facesContext;
    private User user;

    /**
     * Initializes the LoginController after construction.
     */
    @PostConstruct
    private void postConstruct() {
        LOG.info("LoginController.postConstruct");
        user = new User();
    }

    /**
     * Registers a new user in the system.
     * 
     * @return The outcome page after registration.
     */
    public String registerUser() {
        String username = user.getUserName();
        String password = user.getPassword();

        // Create a new user
        userService.create(user);

        // Log in the new user
        String loginOutcome = doLogin(username, password);

        if (loginOutcome.equals("/welcome.xhtml?faces-redirect=true")) {
            // Registration and login successful, redirect to registration success page
            return "/registrationSuccess.xhtml?faces-redirect=true";
        } else {
            // Registration or login failed, redirect to error page
            return "/registrationError.xhtml?faces-redirect=true";
        }
    }

    /**
     * Retrieves the authenticated user.
     * 
     * @return The authenticated user's username.
     */
    public String getAuthenticatedUser() {
        return securityContext.getCallerPrincipal().getName();
    }

    /**
     * Checks if the authenticated user has the MANUFACTURER_ROLE.
     * 
     * @return True if the user has the MANUFACTURER_ROLE, false otherwise.
     */
    public boolean isManufacturer() {
        return securityContext.isCallerInRole("MANUFACTURER_ROLE");
    }

    /**
     * Checks if the authenticated user has the SALESSTAFF_ROLE.
     * 
     * @return True if the user has the SALESSTAFF_ROLE, false otherwise.
     */
    public boolean isSalesstaff() {
        return securityContext.isCallerInRole("SALESSTAFF_ROLE");
    }

    /**
     * Checks if the authenticated user has the ADMIN_ROLE.
     * 
     * @return True if the user has the ADMIN_ROLE, false otherwise.
     */
    public boolean isAdmin() {
        return securityContext.isCallerInRole("ADMIN_ROLE");
    }

    /**
     * Performs user login with the provided username and password.
     * 
     * @param username The username of the user.
     * @param password The password of the user.
     * @return The outcome page after login.
     */
    public String doLogin(String username, String password) {
        LOG.info("LoginController.doLogin");

        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
        Credential cred = new UsernamePasswordCredential(username, new Password(password));

        AuthenticationStatus status = securityContext.authenticate(
                request,
                response,
                AuthenticationParameters.withParams().credential(cred)
        );

        switch (status) {
            case SUCCESS:
                LOG.info(status.toString());
                return "/welcome.xhtml?faces-redirect=true";
            case SEND_FAILURE:
                LOG.info("FAILURE!" + status.toString());
                return "/loginError.xhtml";
            case NOT_DONE:
                LOG.info("NOT DONE!" + status.toString());
                return "/loginError.xhtml";
            case SEND_CONTINUE:
                LOG.info(status.toString());
                break;
        }

        return "/loginError.xhtml";
    }

    /**
     * Logs out the authenticated user.
     * 
     * @return The outcome page after logout.
     */
    public String doLogout() {
        LOG.info("LoginController.doLogout");

        try {
            HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
            request.logout();

        } catch (ServletException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }

        return "/login.xhtml?faces-redirect=true";
    }

    /**
     * Retrieves the current user.
     * 
     * @return The current user.
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the current user.
     * 
     * @param user The user to set.
     */
    public void setUser(User user) {
        this.user = user;
    }
}
