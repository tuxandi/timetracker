package ad.asc.jonny.inserts;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;



public class InsertTimeslices {
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
	  		
	  		System.out.println("Enter Taskid");
	  		int taskid = number.nextInt();
	  		
	  		System.out.println("Userid");
	  		int userid = number.nextInt();
	  		
	  		System.out.println("Enter start time");
	  		int startts = number.nextInt();
	  		
	  		System.out.println("Enter ends time");
	  		int endts = number.nextInt();
	  		
	  		System.out.println("Enter Comment");
	  		String comment = scanner.nextLine();
	  		
	  		System.out.println("Erfolgreich");
	  		try {
	  			
	  		conn = getConnection();
	  		
	  		String query = "INSERt INTO timeslices (taskid,userid,startts,endts,comment)" 
					+ "VALUES (?,?,?,?,?);";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,taskid );
			pstmt.setInt(2, userid);
			pstmt.setInt(3, startts);
			pstmt.setInt(4,endts);
			pstmt.setString(5, comment);
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