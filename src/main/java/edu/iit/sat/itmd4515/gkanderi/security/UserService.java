package edu.iit.sat.itmd4515.gkanderi.security;

import edu.iit.sat.itmd4515.gkanderi.security.User;
import edu.iit.sat.itmd4515.gkanderi.service.AbstractService;
import jakarta.ejb.Stateless;
import java.util.List;

/**
 * This class provides services related to the User entity.
 * It extends the AbstractService class and is annotated as Stateless.
 * 
 * @author 18722
 */
@Stateless
public class UserService extends AbstractService<User> {

    /**
     * Constructs a new UserService.
     */
    public UserService() {
        super(User.class);
    }

    /**
     * Retrieves all users from the database.
     * 
     * @return A list of all users.
     */
    public List<User> findAllUsers() {
        return super.findAll("User.findAll");
    }

    /**
     * Creates a new user in the database.
     * 
     * @param user The user to be created.
     */
    public void createUser(User user) {
        super.create(user);
    }
}
