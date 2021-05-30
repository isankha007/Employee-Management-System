import java.util.List;

public class Employee extends User  {
       String empId;
       Double salary;
       Department dpt;
       String emailID;
       

	public Employee(String firstName, String lastName, String dOB, String userType, String empId, Double salary,
			Department dpt, String emailID) {
		super(firstName, lastName, dOB, userType);
		this.empId = empId;
		this.salary = salary;
		this.dpt = dpt;
		this.emailID = emailID;
	}

	public Employee(String firstName, String lastName, String dOB, String empId, Double salary,
			Department dpt,String userType) {
		super(firstName, lastName, dOB, userType);
		this.empId = empId;
		this.salary = salary;
		this.dpt = dpt;
	}

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

//	public Employee(String firstName, String lastName, String dOB, String empId) {
//		super(firstName, lastName, dOB,userType);
//		this.empId = empId;
//	}
//
//	
//
//	public Employee(String firstName, String lastName, String dOB, String empId, Double salary,
//			Department dpt) {
//		super(firstNamelastName, dOB,userType);
//		this.empId = empId;
//		this.salary = salary;
//		this.DOB = dOB;
//		this.dpt = dpt;
//	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Department getDpt() {
		return dpt;
	}

	public void setDpt(Department dpt) {
		this.dpt = dpt;
	}
	
	
       
}
