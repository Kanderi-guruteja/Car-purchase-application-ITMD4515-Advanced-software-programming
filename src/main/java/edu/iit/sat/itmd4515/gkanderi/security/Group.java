package edu.iit.sat.itmd4515.gkanderi.security;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * Entity class representing a security group.
 * Groups are used for organizing users and managing permissions.
 * 
 * Each group has a name, description, and a list of users associated with it.
 * 
 * @author 18722
 */
@Entity
@Table(name = "SEC_GROUP")
@NamedQuery(name = "Group.findAll", query = "select g from Group g")
public class Group {

    @Id
    private String groupName;
    private String groupDescription;

    @ManyToMany(mappedBy = "groups")
    private List<User> users = new ArrayList<>();

    /**
     * Constructs a new Group instance with the specified group name and description.
     * 
     * @param groupName the name of the group
     * @param groupDescription the description of the group
     */
    public Group(String groupName, String groupDescription) {
        this.groupName = groupName;
        this.groupDescription = groupDescription;
    }

    /**
     * Default constructor.
     */
    public Group() {
    }

    /**
     * Get the value of groupName.
     * 
     * @return the value of groupName
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * Set the value of groupName.
     * 
     * @param groupName the new value of groupName
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * Get the value of groupDescription.
     * 
     * @return the value of groupDescription
     */
    public String getGroupDescription() {
        return groupDescription;
    }

    /**
     * Set the value of groupDescription.
     * 
     * @param groupDescription the new value of groupDescription
     */
    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }

    /**
     * Get the list of users associated with this group.
     * 
     * @return the list of users
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * Set the list of users associated with this group.
     * 
     * @param users the list of users to set
     */
    public void setUsers(List<User> users) {
        this.users = users;
    }

}
