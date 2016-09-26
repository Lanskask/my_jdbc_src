import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class prepared_statement {

	public static void main(String[] args) throws SQLException{
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		String url = "jdbc:mysql://localhost:3306/demo";
		String user = "root";
		String password = "root";
		
		try {
			myConn = DriverManager.getConnection(url, user, password);
			myStmt = myConn.prepareStatement(
					"select * from employees where salary > ?" +
					"and department = ?");
			System.out.println("Salary > 80 000; Legal\n");
			myStmt.setDouble(1, 80000);
			myStmt.setString(2, "Legal");
			
			myRs = myStmt.executeQuery();
			
			display(myRs);
			
			// Reusing a query
			
			System.out.println("\n\nReusing\n\n");
			System.out.println("Salary > 25 000; HR:\n");
			myStmt.setDouble(1, 25000);
			myStmt.setString(2, "HR");
			
			myRs = myStmt.executeQuery();
			
			display(myRs);
			
			System.out.println("Query exequted!");
			
		} catch (Exception exc) {
			exc.printStackTrace();
//			System.out.println("Access denied!");
			System.out.println("Query NOT exequted! Try again.");
		}
		
	}
	
	private static void display(ResultSet myRs) throws SQLException {
		while (myRs.next()) {
			String lastName = myRs.getString("last_name");
			String firstName = myRs.getString("first_name");
			double salary = myRs.getDouble("salary");
			String department = myRs.getString("department");
			
			System.out.printf("%s, %s, %.2f, %s\n", lastName, firstName, salary, department);
		}
	}
	
}
