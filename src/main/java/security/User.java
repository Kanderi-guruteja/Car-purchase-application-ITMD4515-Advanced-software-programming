package security;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    
    @Id
    private String userName;
    
    private String password;

    @ManyToMany
    private List<Group> groups = new ArrayList<>();
    
    public User() {
        // Default constructor for JPA
    }

    // Constructors, getters, and setters

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    // Getters and setters

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    // Helper methods to manage group associations

    public void addGroup(Group group) {
        this.groups.add(group);
        group.getUsers().add(this);
    }

    public void removeGroup(Group group) {
        this.groups.remove(group);
        group.getUsers().remove(this);
    }
}