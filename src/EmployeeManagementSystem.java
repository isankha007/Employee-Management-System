import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;  
import java.util.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;



public class EmployeeManagementSystem {
	
	public static void storeIT(ArrayList<Employee> employee) {
		try {
			FileOutputStream f = new FileOutputStream("EmpList.ser");
			ObjectOutputStream os = new ObjectOutputStream(f);
			os.writeObject(employee);
			os.close();
			
		} catch (IOException e) {
			e.printStackTrace();
			// TODO: handle exceptions
		}
	}
	@SuppressWarnings("unchecked")
	public static void fetchIT() {
		// TODO Auto-generated constructor stub
		try {
			FileInputStream f = new FileInputStream("EmpList.ser");
			ObjectInputStream os = new ObjectInputStream(f);
			employees=(ArrayList<Employee>)os.readObject();
			os.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			}
		}
	public static boolean IsAgeAllowed(String dateStr) {
		 try {
			  Date date=new SimpleDateFormat("ddMMyyyy").parse(dateStr);
		      //Converting obtained Date object to LocalDate object
		      Instant instant = date.toInstant();
		      ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
		      LocalDate givenDate = zone.toLocalDate();
		      //Calculating the difference between given date to current date.
		      Period period = Period.between(givenDate, LocalDate.now());
		      if(period.getYears()<24) {
		    	  return false;
		      }
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return true;
		
	}
     static ArrayList<Employee> employees=new ArrayList<Employee>();;
     //fetchIt();
	 public static void menuAdmin()
	  {
	    System.out.println("\t\t*******************************************");
	    System.out.println("\t\t\t  EMPLOYEE MANAGEMENT SYSTEM");
	    System.out.println("\t\t*******************************************");
	    System.out.println("\t\t\t    --------------------");
	    System.out.println("\t\t\t     ~$ Sankhadeep ");
	    System.out.println("\t\t\t    --------------------");
	    System.out.println("\n\nPress 1 : To Add an Employee Details");
	    System.out.println("Press 2 : To See an Employee Details ");
	    System.out.println("Press 3 : To Remove an Employee");
	    System.out.println("Press 4 : To Update Employee Details");
	    System.out.println("Press 5 : To Exit the EMS Portal");
	  }
	 public void viewFile(String s) throws Exception
	  {
	    File file = new File("file"+s+".txt");
	    Scanner sc = new Scanner(file);

	    while (sc.hasNextLine())
	     {
	       System.out.println(sc.nextLine());
	     }
	   }
	 
	public static int addEmployee() {
		 Scanner sc=new Scanner(System.in);
		 String firstName;
         String lastName;
         String dOB;
         String empId;
         Double salary;
        // String employ_contact;
         Department dpt= new Department();
         //Scanner sc=new Scanner(System.in);
         System.out.print("Enter Employee's  first name --------: ");
         firstName=sc.nextLine();
         System.out.print("Enter Employee's  last name -: ");
         lastName=sc.nextLine();
         System.out.print("Enter Employee's ID ----------:");
         empId=sc.nextLine();
         Iterator itr = employees.iterator();
         while (itr.hasNext())
         {
             Employee emp = (Employee) itr.next();
             if (emp.empId.equals(empId)) {
                 System.out.println("ID Already exist");
                 return 0;}
         }
         System.out.print("Enter Employee's DOB ----:");
         dOB=sc.nextLine();
        if(!IsAgeAllowed(dOB)) {
        	System.out.print("Age should be >= 24 ----:");
        	return 0;
        }
         System.out.print("Enter Employee's Dept ID ----:");
         dpt.departmentId=sc.nextLine();
         System.out.print("Enter Employee's Dept Name ----:");
         dpt.departmentName=sc.nextLine();
         System.out.print("Enter Employee's Salary ------:");
         salary=Double.parseDouble(sc.nextLine()) ;  
   	  Employee emp= new Employee(firstName, lastName, dOB, empId, salary, dpt,"EMP");
   	  employees.add(emp);
   	  return 1;
	} 
	
	public static int updateEmployee(String empIDSearch) {

        Iterator itr = employees.iterator();
        while (itr.hasNext())
        {
            Employee emp = (Employee) itr.next();
            if (emp.empId.equals(empIDSearch)) {
	       		Scanner sc=new Scanner(System.in);
	            Department dpt= new Department();
	            //Scanner sc=new Scanner(System.in);
	            System.out.print("Enter Employee's  first name --------: ");
	            emp.firstName=sc.nextLine();
	            System.out.print("Enter Employee's  last name -: ");
	            emp.lastName=sc.nextLine();
	            System.out.print("Enter Employee's DOB ----:");
	            String dOB=sc.nextLine();
	            if(!IsAgeAllowed(dOB)) {
	            	System.out.print("Age should be >= 24 ----:");
	            	return 0;
	            }
	            System.out.print("Enter Employee's Dept ID ----:");
	            emp.dpt.departmentId=sc.nextLine();
	            System.out.print("Enter Employee's Dept Name ----:");
	            emp.dpt.departmentName=sc.nextLine();
	            System.out.print("Enter Employee's Salary ------:");
	            return 1;
            }
        }
 
  	  //Employee emp= new Employee(firstName, lastName, dOB, empId, salary, dpt,"EMP");
  	 // employees.add(emp);
  	  return 0;
	} 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/** To clear the output Screen **/
	   // System.out.print("\033[H\033[2J");
		//fetchIT();
	    Scanner sc=new Scanner(System.in);
	    User usr= new User();
	    System.out.println("Login as (User/Admin)");
	    usr.userType= sc.nextLine();

	    int i=0;

	    menuAdmin();

	    while(i<6)
	    {

	      System.out.print("\nPlease Enter choice :");
	      i=Integer.parseInt(sc.nextLine());

	      /** Switch Case Statements **/
	      switch(i)
	      {
	        case 1:
	        {
	        	if(!usr.userType.equalsIgnoreCase("admin")) {
	        		System.out.println("only Admin Can add");
	        		break;
	        	}
	        
	        	 addEmployee();
	        	 
	        	  
	        	 // System.out.println(emp);
	           //sc.close();
	       menuAdmin();
	        break;
	        }
	        case 2:
	        {
	          System.out.print("\nPlease Enter Employee's ID :");
	          String empId=sc.nextLine();
	         
	           for(Employee emp:employees) {
	        	   if(empId.equals(empId)) {
	        		   System.out.println("Name "+emp.firstName+" "+emp.lastName);
	        	   }
	           }

	            System.out.print("\nPress Enter to Continue...");
	            sc.nextLine();
	            menuAdmin();
	            break;
	          }

	        case 3:
	        {
	        	if(!usr.userType.equalsIgnoreCase("admin")) {
	        		System.out.println("only Admin Can Remove");
	        		break;
	        	}
	          System.out.print("\nPlease Enter Employee's ID :");
	          String empId=sc.nextLine();
	          Iterator<Employee> itr = employees.iterator();
	          while (itr.hasNext())
	          {
	              Employee emp = (Employee) itr.next();
	              if (emp.empId.equals(empId))
	                  itr.remove();
	          }
	          break;
	        }
	        case 4:
	        {
	        	if(!usr.userType.equalsIgnoreCase("admin")) {
	        		System.out.println("only Admin Can Update");
	        		break;
	        	}
		          System.out.print("\nPlease Enter Employee's ID to Update :");
		          String empId=sc.nextLine();
		          updateEmployee(empId);
	        	break;
	        }
	        case 5:
	        {
	        	    //storeIT(employees);
	        	    System.out.println("\n*****************************************");
	        	    System.out.println("$ cat Thank You For Using my Software :) ");
	        	    System.out.println("*****************************************");
	        	    System.out.println(" by Sankha \n");
	        	    //System.exit(0);
	        	    sc.close();
	        	  
	        }
	      
	      }
	    }
	    }
		
  
	}


