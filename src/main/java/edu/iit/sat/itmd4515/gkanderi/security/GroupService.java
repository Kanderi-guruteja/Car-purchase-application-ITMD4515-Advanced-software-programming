package edu.iit.sat.itmd4515.gkanderi.security;

import edu.iit.sat.itmd4515.gkanderi.service.AbstractService;
import jakarta.ejb.Stateless;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Service class for managing Group entities.
 * This class provides methods for CRUD operations on Group entities.
 * 
 * @author 18722
 */
@Stateless
public class GroupService extends AbstractService<Group> {

    /**
     * Default constructor.
     * Initializes the GroupService with the Group entity class.
     */
    public GroupService() {
        super(Group.class);
    }

    /**
     * Retrieves all groups from the database.
     * 
     * @return a list of all groups
     */
    public List<Group> findAll() {
        return super.findAll("Group.findAll");
    }

    /**
     * Finds a group by its name.
     * 
     * @param groupName the name of the group to find
     * @return the group with the specified name, or null if not found
     */
    public Group findByName(String groupName) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("groupName", groupName);
        return super.findOneResult("SELECT g FROM Group g WHERE g.groupName = :groupName", parameters);
    }
}
