package edu.iit.sat.itmd4515.gkanderi.security;

import edu.iit.sat.itmd4515.gkanderi.service.AbstractService;
import jakarta.ejb.Stateless;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Group findByName(String groupName) {
    Map<String, Object> parameters = new HashMap<>();
    parameters.put("groupName", groupName);
    return super.findOneResult("SELECT g FROM Group g WHERE g.groupName = :groupName", parameters);
}
}
