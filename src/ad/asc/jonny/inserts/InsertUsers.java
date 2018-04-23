package ad.asc.jonny.inserts;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;



public class InsertUsers {
  public static Connection getConnection() throws Exception {
	  		String url = "jdbc:postgresql://localhost:5432/timetracker";
	  		String username = "time";
	  		String password = "jonas";
	  		Class.forName("org.postgresql.Driver");
	  		Connection conn = DriverManager.getConnection(url, username, password);
    		
	  		return conn;
  }
  public static void main(String[] args) throws Exception {
	  		Connection conn = null;
	  		PreparedStatement pstmt = null;
	  		Scanner scanner = new Scanner(System.in);
	  		Scanner number = new Scanner(System.in);
	  		
	  		System.out.println("Enter Userid");
	  		int userid = number.nextInt();
	  		
	  		System.out.println("Enter your Mandantid");
	  		int mandantid = number.nextInt();
	  		
	  		System.out.println("Enter your Lastname");
	  		String name = scanner.nextLine();
	  		
	  		System.out.println("Enter Firstname");
	  		String firstname = scanner.nextLine();
	  		
	  		System.out.println("Enter your Email address");
	  		String email = scanner.nextLine();
	  		
	  		System.out.println("Erfolgreich");
	  		try {
	  			
	  		conn = getConnection();
	  		
	  		String query = "INSERt INTO users (userid,mandantid,name,firstname,email)" 
					+ "VALUES (?,?,?,?,?);";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, userid);
			pstmt.setInt(2, mandantid);
			pstmt.setString(3, name);
			pstmt.setString(4,firstname);
			pstmt.setString(5, email);
			pstmt.executeUpdate();
	  		
			
	  		} catch (Exception e) {
	  			e.printStackTrace();
	  			
	  		} finally {
	  			pstmt.close();
	  			conn.close();
	  			scanner.close();
	  			number.close();
	  		}
  }
  }