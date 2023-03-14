package edbms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import customeexception.EmployeeNotFoundException;
import customeexception.InvalidChoiceException;

public class EmployeeManagementSystemImpl implements EmployeeManagementSystem{
	Scanner scan=new Scanner(System.in);
	int count=0;
	private void dataBase(String  id,String name,int age,double sal) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/oracleemp","root","root");
			PreparedStatement ps=connection.prepareStatement("insert into employee values(?,?,?,?)");
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setInt(3, age);
			ps.setDouble(4, sal);
			ps.execute();
			System.out.println("Record with id:"+id+"  added to data base");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public void addEmployee() {
		// TODO Auto-generated method stub
		System.out.println("Enter id:");
		String id=scan.next().toUpperCase();
		System.out.println("Enter Name:");
		String name=scan.next();
		System.out.println("Enter Age:");
		int age=scan.nextInt();
		System.out.println("Enter Salary:");
		double sal=scan.nextDouble();
		//		Employee emp=new Employee(name,id, age, sal);

		dataBase(id,name,age,sal);

	}

	@Override
	public void displayEmployee() {
		// TODO Auto-generated method stub
		System.out.println("Enter Id:");
		String id=scan.next().toUpperCase();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/oracleemp","root","root");
			PreparedStatement ps=connection.prepareStatement("select * from employee where id=?");
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				System.out.println("ID: "+rs.getString(1)+"  ,Name:"+rs.getString(2)+"  ,Age: "+rs.getInt(3)+"   ,Sal: "+rs.getDouble(4));
			}
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}


	}

	@Override
	public void displayAllEmployee() {
		// TODO Auto-generated method stub
		System.out.println("From Date base");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/oracleemp","root","root");
			PreparedStatement ps=connection.prepareStatement("select * from employee");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println("ID: "+rs.getString(1)+"  ,Name:"+rs.getString(2)+"  ,Age: "+rs.getInt(3)+"   ,Sal: "+rs.getDouble(4));
				count++;
			}
		} 
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void removeEmployee() {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/oracleemp","root","root");
			PreparedStatement ps=connection.prepareStatement("delete from employee where id=?");
			System.out.println("Enter employee id of to delete that row");
			ps.setString(1, scan.next().toUpperCase());
			ps.execute();
			connection.close();
			System.out.println("Deleted record");
		}
		catch(ClassNotFoundException |SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void removeAllEmployee() {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/oracleemp","root","root");
			PreparedStatement ps=connection.prepareStatement("truncate table employee");
			ps.execute();
			connection.close();
			System.out.println("Deleted all records");
		}
		catch(ClassNotFoundException |SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void countEmployee() {
		// TODO Auto-generated method stub
		System.out.println("Total no of records present in DateBase id:"+count);
	}

	@Override
	public void updateEmployee() {
		// TODO Auto-generated method stub
		System.out.println("What you want to update?");
		System.out.println("1.id\n2.Name\n3.Age\n4.Sal");
		int choice =scan.nextInt();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/oracleemp","root","root");
			System.out.println("Enter id of row you want to edit:");
			String id=scan.next();	
			switch(choice) {
			case 1:
				System.out.println("Enter the new id");
				String id1=scan.next();
				PreparedStatement preparedStatement=connection.prepareStatement("update  employee set id=? where id=?");
				preparedStatement.setString(1, id1);
				preparedStatement.setString(2, id);
				preparedStatement.execute();
				break;
			case 2:
				System.out.println("Enter new name");
				String name=scan.next();
				PreparedStatement preparedStatement2=connection.prepareStatement("update employee set name=? where id=?");
				preparedStatement2.setString(1, name);
				preparedStatement2.setString(2, id);
				preparedStatement2.execute();
				System.out.println("Old Name converted to new name:"+name);
				break;

			case 3:
				System.out.println("Enter new Age");
				int age=scan.nextInt();	
				PreparedStatement preparedStatement3=connection.prepareStatement("update employee set age=? where id=?");
				preparedStatement3.setInt(1, age);
				preparedStatement3.setString(2, id);
				preparedStatement3.execute();
				System.out.println("Old Age converted to new Age:"+age);
				break;
			case 4:
				System.out.println("Enter new Sal");
				double sal=scan.nextDouble();
				PreparedStatement preparedStatement4=connection.prepareStatement("update employee set sal=? where id=?");
				preparedStatement4.setDouble(1, sal);
				preparedStatement4.setString(2, id);
				preparedStatement4.execute();
				System.out.println("Old sal converted to new Sal:"+sal);
				break;

			default:
				System.out.println("Invalid Choice");
				connection.close();
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

	@Override
	public void sortEmployee() {
		// TODO Auto-generated method stub
			System.out.println("Enter Choice");
			System.out.println("1.Sort By Age\n2.Sort by Salary\n3.Exit");
			int choice=scan.nextInt();
			switch(choice) {
			case 1:
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/oracleemp","root","root");
					PreparedStatement ps=connection.prepareStatement("select * from employee order by age");
					ResultSet rs=ps.executeQuery();
					while(rs.next()) {
						System.out.println("ID: "+rs.getString(1)+"  ,Name:"+rs.getString(2)+"  ,Age: "+rs.getInt(3)+"   ,Sal: "+rs.getDouble(4));
						count++;
					}
				} 
				catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				break;

			case 2:
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/oracleemp","root","root");
					PreparedStatement ps=connection.prepareStatement("select * from employee order by sal");
					ResultSet rs=ps.executeQuery();
					while(rs.next()) {
						System.out.println("ID: "+rs.getString(1)+"  ,Name:"+rs.getString(2)+"  ,Age: "+rs.getInt(3)+"   ,Sal: "+rs.getDouble(4));
						count++;
					}
				} 
				catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				break;
				
			case 4:
				System.out.println("Exited Update");
				System.exit(0);

			default:
				try {
					new InvalidChoiceException("Invaid choice");
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			
			}
	}

	@Override
	public void displayEmployeeWithHighestSal() {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/oracleemp","root","root");
			PreparedStatement ps=connection.prepareStatement("Select * from employee where sal=(select MAX(sal) from employee)");
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				System.out.println("ID: "+rs.getString(1)+"  ,Name:"+rs.getString(2)+"  ,Age: "+rs.getInt(3)+"   ,Sal: "+rs.getDouble(4));
			}
			connection.close();

		} 
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void displayEmployeeWithLowestSal() {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/oracleemp","root","root");
			PreparedStatement ps=connection.prepareStatement("Select * from employee where sal=(select min(sal) from employee)");
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				System.out.println("ID: "+rs.getString(1)+"  ,Name:"+rs.getString(2)+"  ,Age: "+rs.getInt(3)+"   ,Sal: "+rs.getDouble(4));
			}
			connection.close();

		} 
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}