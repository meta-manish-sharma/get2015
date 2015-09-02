/**
 * Employee class have empId name and address of employee
 * and implement comparable interface and sort employee by 
 * empId of employee
 * @author Manish
 *
 */
public class Employee implements Comparable {

	private String empId;
	private String name;
	private String address;
	
	public String getEmpId() {
		return empId;
	}
	
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Employee() { 
		empId = "";
		name = "";
		address = "";
	}
	
	public Employee(String empId, String name, String address) {
		this.empId=empId;
		this.name=name;
		this.address=address;
	}
	
	
	
	@Override
	public String toString() {
		
		return " EmpId : "+empId+" Name : "+name+" Address : "+address ;
	}

	@Override
	public int compareTo(Object obj) {
		Employee emp = (Employee) obj;
		return getEmpId().compareTo(emp.getEmpId());
	}
	
	@Override
	public boolean equals(Object obj) {
		Employee emp = (Employee) obj;
		if(this.empId.equalsIgnoreCase(emp.getEmpId())){
			return true;
		}
		else {
				return false; 
		}
	}
	
	@Override
	public int hashCode() {
		 final int prime = 31;
	        int result = 1;
	        result = prime * result + Integer.parseInt(this.empId);
	        return result;
	}
}
