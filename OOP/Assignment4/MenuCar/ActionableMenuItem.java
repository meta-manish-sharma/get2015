package MenuCar;

//Class performing action based on choice
public class ActionableMenuItem implements MenuItem{
	
	String displayText; 
	
	ActionableMenuItem(String displayText) {
		this.displayText = displayText;
	}
	
	@Override
	public void display() {
		System.out.println(displayText);
		
	}

	
	@Override
	public void takeAction(int choice) {
		
		CarService carObject = new CarService();
		
		switch(choice){
		
		case 1:
			carObject.displayCarAllocation();
			break;
			
		case 2:
			
			carObject.showReportForDay(CarService.totalEarning());
			break;
			
		case 3: System.exit(0);
			
		}
		
	}

}