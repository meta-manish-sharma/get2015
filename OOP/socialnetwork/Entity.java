package socialnetwork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Manish
 */
public class Entity {
    String email;
    String name;
    HashMap<String,String> friends=new HashMap<String,String>();
    public Entity(String email, String name) {
        this.email = email;
        this.name = name;
    }
    

    
    }
