
package socialnetwork;

import java.util.ArrayList;
import java.util.List;

/**
*
* @author Manish
*/
public class Organisation extends Entity implements Record{
    long phoneNumber;
     ArrayList<String> friends=new ArrayList<String>();
     String placementRecord;
     public Organisation(long phoneNumber,String email,String name){
        super(email,name);
        this.phoneNumber=phoneNumber;
    }

    @Override
    public void setInterest(String interest) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getInterest() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPlacementRecord(String placementRecord) {
    this.placementRecord=placementRecord;    
    }

    @Override
    public String getPlacementRecord() {
        
    return placementRecord;
            }
    
}
