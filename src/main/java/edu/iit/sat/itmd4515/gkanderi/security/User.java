package edu.iit.sat.itmd4515.gkanderi.security;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 18722
 */
@Entity
@Table(name = "SEC_USER")
@EntityListeners(UserPasswordHash.class)
@NamedQuery(name = "User.findAll", query = "select u from User u")
public class User {

    @Id
    @NotBlank(message = "Please enter a username")
    private String userName;
    @NotBlank(message = "Please enter a password")
    private String password;
    
    @ManyToMany
    @JoinTable(name = "SEC_USER_GROUPS",
            joinColumns = @JoinColumn(name="USERNAME"),
            inverseJoinColumns = @JoinColumn(name="GROUPNAME"))
    private List<Group> groups = new ArrayList<>();

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User() {
    }
    public void addGroup(Group g){
        this.groups.add(g);
        g.getUsers().add(this);
    }
    
    public void removeGroup(Group g){
        this.groups.remove(g);
        g.getUsers().remove(this);
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

}