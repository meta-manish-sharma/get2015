
package socialnetwork;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
*
* @author Manish
*/
public class SocialNetwork {
    
    
    
    public static void main(String args[]){
        ArrayList<Entity> personList=new ArrayList<Entity>();
        Node node=new Node();
        try {
           personList =node.addNode();
        } catch (IOException ex) {
            Logger.getLogger(SocialNetwork.class.getName()).log(Level.SEVERE, null, ex);
        }
        int choice = 1;
        
           
       while(true){
        Iterator<Entity> person1;
        Iterator<Entity> person2;
           
        person1 = personList.iterator();
        person2=personList.iterator();
        System.out.println("Enter your Email Id");
        String email;
        Scanner sc = new Scanner(System.in);
        email = sc.next();
       // int  flag = 0;
        Person personObject=null;
        Person currentPerson=null;
        Graph graph=new Graph();
        while (person1.hasNext()) {
	 personObject = (Person) person1.next();
				
                    if(personObject.email.equalsIgnoreCase(email)){
                    currentPerson=personObject;
                    System.out.println(currentPerson.name+" "+currentPerson.phoneNumber);
                   // flag=1;
                    break;
                }
        }
        while(true){
        System.out.println("press 1 to see your friend List");
        System.out.println("press 2 to add your friend");
        System.out.println("press 3 to remove your friend");
        System.out.println("press 4 for Sign Out");
        System.out.println("press 5 exit the application");
                   
                    choice=sc.nextInt();
                  // Iterator<Entity> personFriend=personObject.friends.iterator();
                   if(choice==1){
                       currentPerson.showFriends();
                   }
                   if(choice==2){
                    System.out.println("please enter your frinds Email ID");
                    String friendEmail=sc.next();
                while (person2.hasNext()) {
		Person friendObject = (Person)person2.next();
				
                 if(friendObject.email.equalsIgnoreCase(friendEmail)){
                  
                  graph.addConnection(currentPerson, friendObject);
                  break;
                   }
                   
                }
                   }
                   if(choice==3){
                    System.out.println("please enter your frinds Email ID whom you want to remove");
                    String friendEmail=sc.next();
                while (person2.hasNext()) {
                Person friendObject = (Person)person2.next();
				
                 if(friendObject.email.equalsIgnoreCase(friendEmail)){
                  
                  graph.removeConnection(currentPerson,friendObject);
                  break;
                   }
                   
                }
                   }
                   
                   if(choice==4){
                      break;
                   }
                   if(choice==5){
                       System.exit(0);
                   }
                    
                }
        }        
                    
                    
                    
                    
                        
}
}
