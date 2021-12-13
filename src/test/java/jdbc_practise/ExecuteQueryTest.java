package jdbc_practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class ExecuteQueryTest {

	@Test
	public void executeQuery() throws SQLException
	{
		// Step 1 Register the driver
		
		Driver dref = new Driver();
		DriverManager.registerDriver(dref);
		
		// Step 2 connect to the database
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
		
		// Step 3 create statement
		Statement stmt = connect.createStatement();
		
		// Step 4 Execute query 
		ResultSet result = stmt.executeQuery("select * from students_info");
		while(result.next())
		{
			System.out.println(result.getString(1)+ " "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4));
		}
		
		// Step 5 close the connection
		
		connect.close();
		
	}
}
