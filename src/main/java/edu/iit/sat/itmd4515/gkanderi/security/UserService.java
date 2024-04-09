package edu.iit.sat.itmd4515.gkanderi.security;
import edu.iit.sat.itmd4515.gkanderi.service.AbstractService;
import jakarta.ejb.Stateless;
import java.util.List;

/**
 *
 * @author 18722
 */
@Stateless
public class UserService extends AbstractService<User> {

    public UserService() {
        super(User.class);
    }
    
    public List<User> findAll(){
        return super.findAll("User.findAll");
    }
}