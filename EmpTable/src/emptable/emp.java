package emptable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class emp {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	
			Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/oracleemp","root","root");
			Statement statement=connection.createStatement();
//			statement.execute("insert into emp values( 7369,'SMITH','CLERK',7902,'1980-12-17', 800,0,20)");
//			statement.execute("insert into emp values( 7499 ,'ALLEN','SALESMAN',7698,'1981-02-21',1600,300,30)");
//			statement.execute("insert into emp values(  7521 ,'WARD','SALESMAN',7698,'1981-02-22',1250,500, 30)");
//			statement.execute("insert into emp values( 7566 ,'JONES','MANAGER',7839,'1981-04-02',2975,null,20)");
//			statement.execute("insert into emp values(  7654, 'MARTIN','SALESMAN',7698,'1981-09-28', 1250,1400 ,30)");
//			statement.execute("insert into emp values(  7698,'BLAKE','MANAGER',7839,'1981-05-01',2850,null, 30)");
//			statement.execute("insert into emp values( 7782,'CLARK','MANAGER', 7839,'1981-06-09',2450,null,10)");
//			statement.execute("insert into emp values( 7788 ,'SCOTT','ANALYST',7566,'1987-04-19',3000,null,20)");
//			statement.execute(" insert into emp values(7839,'KING','PRESIDENT',null,'1981-11-17',5000,null,10)");
//			statement.execute(" insert into emp values(7844,'TURNER','SALESMAN',7698,'1981-09-08',1500,0, 30)");
//			statement.execute(" insert into emp values(7876,'ADAMS','CLERK',7788,'1987-05-23',1100,null,20)");
//			statement.execute("insert into emp values(7900,'JAMES','CLERK',7698,'1981-12-03',950,null,30)");
//			statement.execute(" insert into emp values(7902,'FORD','ANALYST',7566,'1981-12-03',3000,null,20)");
//			statement.execute("insert into emp values(7934,'MILLER','CLERK',7782,'1982-01-23',1300,null,10)");
			ResultSet re=statement.executeQuery("Select * from emp where empno=7499");
			while (re.next()) {
				System.out.println("empno:"+re.getInt(1));
			}
			connection.close();
			System.out.println("Data stored");
		
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
