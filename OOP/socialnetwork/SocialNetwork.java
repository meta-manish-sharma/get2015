package socialnetwork;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
        HashMap<String,Person> personList=new HashMap<String,Person>();
        Node node=new Node();
        try {
           personList =node.addNode();
        } catch (IOException ex) {
            Logger.getLogger(SocialNetwork.class.getName()).log(Level.SEVERE, null, ex);
        }
        int choice = 1;
        
           
       while(true){
   
        System.out.println("Enter your Email Id");
        String email;
        
        Scanner sc = new Scanner(System.in);
        email = sc.next();
        if(personList.containsKey(email)){
        Person currentPerson=null;
        Graph graph=new Graph();
       
        currentPerson=personList.get(email);
        System.out.println("\nWelcome "+currentPerson.name+"\n"+"Mobile No. - "+currentPerson.phoneNumber+"\n"+"your Interest is - "+currentPerson.getInterest());
                   
        while(true){
        System.out.println("\npress 1 to see your friend List");
        System.out.println("press 2 to add your friend");
        System.out.println("press 3 to remove your friend");
        System.out.println("press 4 for Sign Out");
        System.out.println("press 5 exit the application");
                   
                    choice=sc.nextInt();
                    if(choice==1){
                       currentPerson.showFriends();
                   }
                   if(choice==2){
                    System.out.println("please enter your friends Email ID");
                    String friendEmail=sc.next();
                    if(personList.containsKey(friendEmail)){ 
                    Person addFriend=personList.get(friendEmail);
                    graph.addConnection(currentPerson, addFriend);
                    }else{
                        System.out.println("\nYou entered Incorrect Email Id !!");
                    }
                   }
                   
                   if(choice==3){
                       
                    System.out.println("please enter your frinds Email ID whom you want to remove");
                    String friendEmail=sc.next();
                    if(currentPerson.friends.containsKey(friendEmail)){
                    Person friendToRemove=personList.get(friendEmail);
                    graph.removeConnection(currentPerson, friendToRemove);
                    }
                    else{
                        System.out.println("\nYou entered Incorrect Email Id !!");
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
       else{
            System.out.println("please enter Valid Email Id");
       }
       }        
                    
                    
                    
                    
                        
}
}
