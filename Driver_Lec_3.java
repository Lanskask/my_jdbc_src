import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.Driver;

public class Driver_Lec_3 {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://localhost:3306/demo";
		String user = "root";
		String password = "root";
		
		
		try {
			// 1. Get a connection to data
			Connection myConn = DriverManager.getConnection(
					url, user, password);

			// 2. Create a statement
			Statement myStmt = myConn.createStatement();
			
			// 3. Execute SQL query
//			ResultSet myRs = myStmt.executeQuery("SELECT * FROM employees");
/*			String sql = "insert into employees " + 
					" (last_name, first_name, email)" + 
					" values ('Brown', 'David', 'davidB@mail.com')";
*/			
			
/*			String sql_update_email = "update employees " +
					"set email = 'demo@mail.com'" +
					" where id = 5"; */
			String sql_delete = "delete from employees " +
					"where id = 1";
//			myStmt.executeUpdate(sql_update_email);
			myStmt.executeUpdate(sql_delete );
			int rowsAffected = myStmt.executeUpdate(sql_delete);
			
			System.out.println("The affected rows: " + rowsAffected);
//			System.out.println("Insert complete.");
			System.out.println("Updating complete.");
						
		} catch (Exception exc) {
			exc.printStackTrace();
			System.out.println("Access denied!");
		}
		
	}

}
