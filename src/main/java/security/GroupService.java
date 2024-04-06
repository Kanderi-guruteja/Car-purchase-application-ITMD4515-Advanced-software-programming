/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package security;
import edu.iit.sat.itmd4515.gkanderi.service.AbstractService;
import jakarta.ejb.Stateless;
import java.util.List;

/**
 *
 * @author 18722
 */
@Stateless
public class GroupService extends AbstractService<Group>{
     public GroupService(){
         super(Group.class);
    }
     
     public  List<Group>findAll(){
        return super.findAll("Group.findAll");
     }
    
          
    
}
    
