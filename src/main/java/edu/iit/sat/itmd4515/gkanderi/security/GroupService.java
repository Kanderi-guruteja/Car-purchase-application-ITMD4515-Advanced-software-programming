package edu.iit.sat.itmd4515.gkanderi.security;

import edu.iit.sat.itmd4515.gkanderi.service.AbstractService;
import jakarta.ejb.Stateless;
import java.util.List;

/**
 *
 * @author 18722
 */
@Stateless
public class GroupService extends AbstractService<Group> {

    public GroupService() {
        super(Group.class);
    }

    public List<Group> findAll() {
        return super.findAll("Group.findAll");
    }

}
