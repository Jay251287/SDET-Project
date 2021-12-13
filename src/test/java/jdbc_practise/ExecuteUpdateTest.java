package jdbc_practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class ExecuteUpdateTest {
	@Test
	public void executeUpdate() throws SQLException
	{
		// Step 1 Register the driver
		
		Driver dref = new Driver();
		DriverManager.registerDriver(dref);
		
		// Step 2 connect to the database
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
		
		// Step 3 create statement
		Statement stmt = connect.createStatement();
		
		// Step 4 Execute update // here return int is taken because in mysql cmd if insert values gives update 1 row created so we give int return type
		int result = stmt.executeUpdate("insert into students_info(regno, firstname, middlename, lastname) values('4', 'shyam', 'reddy', 'h')");
		if(result == 1) {
			System.out.println("Execute Update passed");
		}
		else
		{
			System.out.println("Execute Update passed");
		}
		
		// Step 5 close the connection
		connect.close();
				
	}
}
