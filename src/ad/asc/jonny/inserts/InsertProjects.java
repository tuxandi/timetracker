package ad.asc.jonny.inserts;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;



public class InsertProjects {
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
	  		
	  		System.out.println("Enter Projectid");
	  		int projectid = number.nextInt();
	  		
	  		System.out.println("Enter your Mandantid");
	  		int mandantid = number.nextInt();
	  		
	  		System.out.println("Enter your Name");
	  		String name = scanner.nextLine();
	  		
	  		System.out.println("Enter Time");
	  		int time = number.nextInt();
	  		
	  		
	  		System.out.println("Erfolgreich");
	  		try {
	  			
	  		conn = getConnection();
	  		
	  		String query = "INSERt INTO projects (projectid,mandantid,name,time)" 
					+ "VALUES (?,?,?,?);";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, projectid);
			pstmt.setInt(2, mandantid);
			pstmt.setString(3, name);
			pstmt.setInt(4,time);
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