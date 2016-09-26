import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.Driver;

public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/demo";
		String user = "root";
		String password = "root";
		
		
		try {
			// 1. Get a connection to data
			java.sql.Connection myConn = DriverManager.getConnection(
					url, user, password);
/* 			java.sql.Connection myConn = 
 * 				DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/demo", 
					"root", 
					"root"); */

			// 2. Create a statement
			Statement myStmt = myConn.createStatement();
			
			// 3. Execute SQL query
			ResultSet myRs = myStmt.executeQuery("SELECT * FROM employees");
			
			// 4. Process the result set
			while (myRs.next()) {
				System.out.println(
						myRs.getString("last_name") + ", " +
						myRs.getString("first_name") 
						); 
			} 
			
			System.out.println("Connection granted! ");
			
		} catch (Exception exc) {
			exc.printStackTrace();
			System.out.println("Access denied!");
		}
		
	}

}
