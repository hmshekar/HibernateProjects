package MypersonDet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Person {
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/mypersondet", "root","root");
			Statement statement=connection.createStatement();
//			statement.execute("insert into person values(101,'smith',21,'male','smith@gmail.com')");
//			statement.execute("insert into person values(102,'allen',24,'male','allen@gmail.com')");
//			System.out.println(statement.execute("insert into person values(103,'sheward',45,'female','sheward@gmail.com')"));
//			statement.execute("insert into person values(104,'jerry',31,'female','jerry@gmail.com')");
//			statement.execute("insert into person values(105,'tiger',16,'male','tigert@gmail.com')");
			System.out.println(statement.execute("update person set name='Nunna' where id=101"));
			ResultSet resultset=statement.executeQuery("select * from person");
			
			while(resultset.next()) {
				System.out.println("ID:"+resultset.getInt(1)+",Name:"+resultset.getString(2)+",Age:"+
			resultset.getInt(3)+",Gender:"+resultset.getString(4)+",Email:"+resultset.getString(5));
			}
			connection.close();
			System.out.println("Data saved");
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
}
