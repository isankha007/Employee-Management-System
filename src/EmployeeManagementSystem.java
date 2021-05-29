import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



public class EmployeeManagementSystem {
     static ArrayList<Employee> employees=new ArrayList<Employee>();;
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
	 
	public static Employee addEmployee() {
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
         System.out.print("Enter Employee's DOB ----:");
         dOB=sc.nextLine();
         System.out.print("Enter Employee's Dept ID ----:");
         dpt.departmentId=sc.nextLine();
         System.out.print("Enter Employee's Dept Name ----:");
         dpt.departmentName=sc.nextLine();
         System.out.print("Enter Employee's Salary ------:");
         salary=Double.parseDouble(sc.nextLine()) ;  
   	  Employee emp= new Employee(firstName, lastName, dOB, empId, salary, dpt,"EMP");
   	  return emp;
	} 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/** To clear the output Screen **/
	   // System.out.print("\033[H\033[2J");

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
	        /** Creating class's object and calling Function using that object **/
	        	/*  String firstName;
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
		          System.out.print("Enter Employee's DOB ----:");
		          dOB=sc.nextLine();
		          System.out.print("Enter Employee's Dept ID ----:");
		          dpt.departmentId=sc.nextLine();
		          System.out.print("Enter Employee's Dept Name ----:");
		          dpt.departmentName=sc.nextLine();
		          System.out.print("Enter Employee's Salary ------:");
		          salary=Double.parseDouble(sc.nextLine()) ;  
	        	  Employee emp= new Employee(firstName, lastName, dOB, empId, salary, dpt,"EMP");*/
	        	  employees.add(addEmployee());
	        	 // System.out.println(emp);
	           //sc.close();

	       // System.out.print("\033[H\033[2J");
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
	          System.out.print("\nPlease Enter Employee's ID :");
	          String s=sc.nextLine();

	          break;
	        }
	        case 4:
	        {
	           /* System.out.print("\nPlease Enter Employee's ID :");
	            String I=sc.nextLine();
	          
	            }
	            catch(IOException e)
	            {
	              System.out.println(e);
	            }*/
	        	break;
	        }
	        case 5:
	        {
	        	
	        	    System.out.println("\n*****************************************");
	        	    System.out.println("$ cat Thank You For Using my Software :) ");
	        	    System.out.println("*****************************************");
	        	    System.out.println("\t\t/~ <0d3d by Sankha \n");
	        	    System.exit(0);
	        	  
	        }
	      
	      }
	    }
	    }
		

	}


