package ad.asc.jonny.inserts;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;



public class Insertmandantuser {
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
	  		//Scanner number = new Scanner(System.in);
	  		
	  		System.out.println("Enter your Mandantid");
	  		int mandantid = scanner.nextInt();
	  		
	  		System.out.println("Enter your UserId");
	  		int userid = scanner.nextInt();
	  		
	  		
	  		System.out.println("Erfolgreich");
	  		try {
	  			
	  		conn = getConnection();
	  		
	  		String query = "INSERT INTO mandantuser (mandantid,userid)" 
					+ "VALUES (?,?);";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, mandantid);
			pstmt.setInt(2, userid);
			pstmt.executeUpdate();
			
	  		} catch (Exception e) {
	  			e.printStackTrace();
	  			
	  		} finally {
	  			pstmt.close();
	  			conn.close();
	  			scanner.close();
	  			//number.close();
	  		}
	  }
}
			