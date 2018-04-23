package ad.asc.jonny.inserts;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;



public class InsertTasks {
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
	  		
	  		System.out.println("Enter your Taskid");
	  		int taskid = number.nextInt();
	  				
	  		System.out.println("Enter TaskName");
	  		String name = scanner.nextLine();
	  		
	  		System.out.println("Enter your PPH");
	  		String pph = scanner.nextLine();
	  		
	  	  		
	  		System.out.println("Done");
	  		try {
	  			
	  		conn = getConnection();
	  		
	  		String query = "INSERt INTO tasks (taskid,name,pph)" 
					+ "VALUES (?,?,?);";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, taskid);
			pstmt.setString(2, name);
			pstmt.setString(3, pph);
		
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