package ad.asc.jonny.inserts;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;



public class InsertMandants {
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
	  		
	  		System.out.println("Enter your Mandantid");
	  		int mandantid = number.nextInt();
	  		
	  		System.out.println("Enter your Name");
	  		String name = scanner.nextLine();
	  		
	  		System.out.println("Enter your address");
	  		String address = scanner.nextLine();
	  		
	  		System.out.println("Enter your Zip");
	  		int zip = number.nextInt();
	  		
	  		System.out.println("Enter your City");
	  		String city = scanner.nextLine();
	  		
	  		System.out.println("Enter your State");
	  		String state = scanner.nextLine();
	  		
	  		System.out.println("Enter your Country");
	  		String country = scanner.nextLine();
	  		
	  		System.out.println("Erfolgreich");
	  		try {
	  			
	  		conn = getConnection();
	  		
	  		String query = "INSERt INTO mandants (mandantid,name,address,zip,city,state,country)" 
					+ "VALUES (?,?,?,?,?,?,?);";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, mandantid);
			pstmt.setString(2, name);
			pstmt.setString(3, address);
			pstmt.setInt(4,zip);
			pstmt.setString(5, city);
			pstmt.setString(6, state);
			pstmt.setString(7, country);
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
			