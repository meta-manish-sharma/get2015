package modelHelper;



public class EmployeeDefault {
	
	 private static EmployeeDefault Instance = new EmployeeDefault();
	 
	 private EmployeeDefault() {
		 
	
		EmployeeCache.add(EmployeeHelper.createEmployee( 1,"Jignesh", 21,
				"10/10/2015", "jmistry94@gmail.com"));
		
		EmployeeCache.add(EmployeeHelper.createEmployee(2,"Manish", 21,
				"14/10/2015", "mainsh@gmail.com"));
		
		EmployeeCache.add(EmployeeHelper.createEmployee(3,"Nikhil", 22,
				"10/9/2015", "nikhil@gmail.com"));
	
		EmployeeCache.add(EmployeeHelper.createEmployee(4,"Subhash", 29,
				"13/10/2015", "subhash@gmail.com"));
	
		EmployeeCache.add(EmployeeHelper.createEmployee(5,"Udit", 19,
				"10/11/2015", "udit@gmail.com"));

	}
	
	 public static EmployeeDefault getInstance( ) {
	      return Instance;
	   }
}
