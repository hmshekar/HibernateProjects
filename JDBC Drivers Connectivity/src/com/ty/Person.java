package com.ty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Person {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/person", "root","root");
			Statement statement =connection.createStatement();
			statement.execute("delete from persondet where id=106");
			connection.close();
			System.out.println("Date stored");
		}
		catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}
		
		
	}
}
