package MenuCar;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Menu {
	
List<MenuItem> items = new ArrayList<>();
	

	
//method adding menu into the item list
public void addMenuItem(MenuItem item){
		
items.add(item);
	
}
	
//method displaying the menu list
public void display() {

Scanner scan  = new Scanner(System.in);		
while (true) {
			
for (MenuItem i : items) {
			
	i.display();
		
	}
			
//setting user's choice
int choice = scan.nextInt();
			
MenuItem i = items.get(choice - 1) ;

i.takeAction(choice);
		

}	

	}

}

