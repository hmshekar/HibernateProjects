package com.ty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeSet;

public class Infosys {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/infosyshiring","root","root");
			Statement statement=connection.createStatement();
			//			statement.execute("insert into infosysemp values(101,'Jaggu',21,'male',9564123025,'Clerk',10000)");
			//			statement.execute("insert into infosysemp values(102,'Raju',25,'male',9564129825,'Assistent',50000)");
			//			statement.execute("insert into infosysemp values(103,'Chutki',25,'female',8794123025,'Assistent',90000)");
			//			statement.execute("insert into infosysemp values(104,'Indhumathi',27,'female',9561230325,'Ceo',500000)");
			//			statement.execute("insert into infosysemp values(105,'ChotaBheem',26,'male',7852134025,'Senior',200000)");
			//			statement.execute("insert into infosysemp values(106,'tuntunmasi',62,'female',6213453025,'Clerk',6000)");
			//			statement.execute("insert into infosysemp values(107,'kaliya',21,'male',6364123025,'Junior',45000)");
			//			statement.execute("insert into infosysemp values(108,'bhollu',21,'male',8764123025,'Junior',20000)");
			//			statement.execute("insert into infosysemp values(109,'dollu',21,'male',7564123025,'Junior',20000)");
			//			statement.execute("insert into infosysemp values(110,'Dhaku',21,'male',9064123025,'junior',600000)");
			//			statement.execute("update infosysemp set designation='Junior' where eid=110");
			statement.execute("delete from infosysemp where age>=60");
			statement.execute("update infosysemp set sal=sal+1 where designation ='senior'");
			
			System.out.println("---------All the Records----------");
			
			ResultSet r1= statement.executeQuery("select * from infosysemp");
			while(r1.next()) {
				System.out.print("id:"+r1.getInt(1)+",Name:"+r1.getString(2)+",Age:"+r1.getInt(3));
				System.out.print(",Gender:"+r1.getString(4)+",PHNO:"+r1.getLong(5)+",Designation:"+r1.getString(6));
				System.out.println(",Salary:"+r1.getInt(7));
			}
			
			System.out.println("--------sal>50000-------------");
			ResultSet r2=statement.executeQuery("select * from infosysemp where sal>50000");
			while(r2.next()) {
				System.out.print("id:"+r2.getInt(1)+",Name:"+r2.getString(2)+",Age:"+r2.getInt(3));
				System.out.print(",Gender:"+r2.getString(4)+",PHNO:"+r2.getLong(5)+",Designation:"+r2.getString(6));
				System.out.println(",Salary:"+r2.getInt(7));
			}
			
			System.out.println("------------Gender='male' & PHNO='95'-----------");
			ResultSet r3=statement.executeQuery("select * from infosysemp where gender='male' and phno like'95%'");
			while(r3.next()) {
				System.out.print("id:"+r3.getInt(1)+",Name:"+r3.getString(2)+",Age:"+r3.getInt(3));
				System.out.print(",Gender:"+r3.getString(4)+",PHNO:"+r3.getLong(5)+",Designation:"+r3.getString(6));
				System.out.println(",Salary:"+r3.getInt(7));
			}
			
			connection.close();
			System.out.println("Data Stored");
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}







