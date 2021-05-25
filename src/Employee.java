import java.util.List;

public class Employee extends User  {
       String empId;
       Double salary;
       String DOB;
       Department dpt;

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

	

	public Employee(String firstName, String lastName, String dOB, String empId, Double salary,
			Department dpt) {
		super(firstName, lastName, dOB);
		this.empId = empId;
		this.salary = salary;
		this.DOB = dOB;
		this.dpt = dpt;
	}

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
