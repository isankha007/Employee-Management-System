import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class EmployeeManagementSystem {

	 public void menu()
	  {
	    System.out.println("\t\t*******************************************");
	    System.out.println("\t\t\t  EMPLOYEE MANAGEMENT SYSTEM");
	    System.out.println("\t\t*******************************************");
	    System.out.println("\t\t\t    --------------------");
	    System.out.println("\t\t\t     ~$ Sankha ");
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/** To clear the output Screen **/
	    System.out.print("\033[H\033[2J");

	    Scanner sc=new Scanner(System.in);
	    Employee_Show epv =new Employee_Show();

	    int i=0;

	    /*** Callining Mainmenu Class function ****/
	    MainMenu obj1 = new MainMenu();
	    obj1.menu();

	    /*** Initialising loop for Menu Choices ***/
	    while(i<6)
	    {

	      System.out.print("\nPlease Enter choice :");
	      i=Integer.parseInt(sc.nextLine());

	      /** Switch Case Statements **/
	      switch(i)
	      {
	        case 1:
	        {
	        /** Creating class's object and calling Function using that object **/
	        Employee_Add ep =new Employee_Add();
	        ep.createFile();

	        System.out.print("\033[H\033[2J");
	        obj1.menu();
	        break;
	        }
	        case 2:
	        {
	          System.out.print("\nPlease Enter Employee's ID :");
	          String s=sc.nextLine();
	          try
	          {
	            epv.viewFile(s);}
	            catch(Exception e){System.out.println(e);}


	            System.out.print("\nPress Enter to Continue...");
	            sc.nextLine();
	            System.out.print("\033[H\033[2J");
	            obj1.menu();
	            break;
	          }

	        case 3:
	        {
	          System.out.print("\nPlease Enter Employee's ID :");
	          String s=sc.nextLine();
	          Employee_Remove epr =new Employee_Remove();
	          epr.removeFile(s);

	          System.out.print("\nPress Enter to Continue...");
	          sc.nextLine();
	          System.out.print("\033[H\033[2J");
	          obj1.menu();
	          break;
	        }
	        case 4:
	        {
	            System.out.print("\nPlease Enter Employee's ID :");
	            String I=sc.nextLine();
	            try
	            {
	              epv.viewFile(I);
	            }
	            catch(Exception e)
	            {
	              System.out.println(e);
	            }
	            Employee_Update epu = new Employee_Update();
	            System.out.print("Please Enter the detail you want to Update :");
	    	      System.out.print("\nFor Example :\n");
	            System.out.println("If you want to Change the Name, then Enter Current Name and Press Enter. Then write the new Name then Press Enter. It will Update the Name.\n");
	            String s=sc.nextLine();
	            System.out.print("Please Enter the Updated Info :");
	            String n=sc.nextLine();
	            try
	            {
	              epu.updateFile(I,s,n);

	              System.out.print("\nPress Enter to Continue...");
	              sc.nextLine();
	              System.out.print("\033[H\033[2J");
	              obj1.menu();
	              break;
	            }
	            catch(IOException e)
	            {
	              System.out.println(e);
	            }
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
