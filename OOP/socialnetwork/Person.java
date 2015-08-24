
package socialnetwork;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
*
* @author Manish
*/
public class Person extends Entity implements Record{
    
    long phoneNumber;
    String interest;
    
   // Iterator<String> personFriend;
    public Person(long phoneNumber,String email,String name){
        super(email,name);
        this.phoneNumber=phoneNumber;
    }

    
 
    @Override
    public void setInterest(String interest) {
        this.interest=interest;
        
    }

    @Override
    public String getInterest() {
     
        return interest;
    }

    @Override
    public void setPlacementRecord(String placementRecord) {
         }

    @Override
    public String getPlacementRecord() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void showFriends(){
    
    
      for(String friendName:friends){
          System.out.println(friendName);
          
      }  
    }
}
