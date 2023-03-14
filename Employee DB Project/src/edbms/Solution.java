package edbms;
import java.util.Scanner;

import customeexception.InvalidChoiceException;
public class Solution {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		EmployeeManagementSystem emp=new EmployeeManagementSystemImpl();
		while(true) {
			System.out.println("======================================");
			System.out.println("Enter Choice");
			System.out.println("1.AddEmp\n2.DispalyEmp\n3.Display AllEmp\n4.Remove Employee");
			System.out.println("5.Remove All Employee\n6.Count Employee\n7.UpdateEmployee\n8.SortEmployee");
			System.out.println("9.Display Emp whith highest sal\n10.Display Emp with Lowest Sal\n11.Exit");
			int choice=scan.nextInt();
			switch(choice) {
			case 1:
				emp.addEmployee();
				break;
			case 2:
				emp.displayEmployee();
				break;
			case 3:
				emp.displayAllEmployee();
				break;
			case 4:
				emp.removeEmployee();
				break;
			case 5:
				emp.removeAllEmployee();
				break;
			case 6:
				emp.countEmployee();
				break;
			case 7:
				emp.updateEmployee();
				break;
			case 8:
				emp.sortEmployee();
				break;
			case 9:
				emp.displayEmployeeWithHighestSal();
				break;
			case 10:
				emp.displayEmployeeWithLowestSal();
				break;
			case 11:
				System.out.println("Thank you");
				System.exit(0);
			default:
				try {
					throw new InvalidChoiceException("Invalid Choice ,Try Again");
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}

			}
		}
	}
}
