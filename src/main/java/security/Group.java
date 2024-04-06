package security;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_group") // Use a different table name that is not a reserved keyword
public class Group {
    
    @Id
    private String groupName;
    
    private String groupDescription;

    @ManyToMany(mappedBy = "groups") // Ensure correct mappedBy attribute
    private List<User> users = new ArrayList<>();
    
    public Group() {
        // Default constructor for JPA
    }


    // Constructors, getters, and setters

    public Group(String groupName, String groupDescription) {
        this.groupName = groupName;
        this.groupDescription = groupDescription;
    }

    // Getters and setters

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
