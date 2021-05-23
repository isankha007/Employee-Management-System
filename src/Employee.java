import java.io.File;
import java.util.Scanner;

public class Employee extends User implements Department {
       String empId;
       String salary;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public Employee(String firstName, String lastName, String dOB, String empId) {
		super(firstName, lastName, dOB);
		this.empId = empId;
	}
	
	
       
}
