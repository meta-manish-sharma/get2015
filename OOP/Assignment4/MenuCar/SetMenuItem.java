package MenuCar;


//class set the menu item 
public class SetMenuItem  {
	SetMenuItem() {
		Menu menu = new Menu();
		ActionableMenuItem item1 = new ActionableMenuItem("Press 1 for show car Allocation");
		ActionableMenuItem item2 = new ActionableMenuItem("Press 2 for Show Report of the day");
		ActionableMenuItem item3 = new ActionableMenuItem("Press 3 for exit");
		
		menu.addMenuItem(item1);
		menu.addMenuItem(item2);
		menu.addMenuItem(item3);
		menu.display();
	}

}