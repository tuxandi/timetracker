/**
 * 
 */
package de.asc.jonny.db;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import de.asc.jonny.models.Mandants;
import de.asc.jonny.models.Mandantuser;
import de.asc.jonny.models.Projects;
import de.asc.jonny.models.Tasks;
import de.asc.jonny.models.Timelices;
import de.asc.jonny.models.User;
/**
 * @author jonas
 *
 */
public class TimeProDB {
	Boolean connected = Boolean.FALSE;

	protected String url = "jdbc:postgresql://localhost:5432/timetracker";
	protected String userid = "time";
	protected String password = "jonas";

	Connection conn = null;
	Statement stmt = null;


	/**
	 * @throws SQLException 
	 * 
	 * 
	 */
	public TimeProDB() throws SQLException {
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("Driver?");
			e.printStackTrace();

		}
		connect(); 
	}
	
	public void finalize() {
		disconnect();

	}
	
	/**
	* 
	* @throws SQLException
	*/
	public void connect() throws SQLException {
		conn  = DriverManager.getConnection(url, userid, password);
		System.out.println("Connected");	//connect to database
		connected = Boolean.TRUE;
	}
	/**
	 * 
	 */
	public void disconnect() {
		if (conn != null && connected) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				connected = Boolean.FALSE;
			}
		}
	}	

	public User getUser(Integer id) throws SQLException {
		if (!connected)
			connect();
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM users where userid ="+ id);
		User user = new User();
		while (rs.next() ) {
			user.userid = rs.getInt("userid");
			
			user.mandantid = rs.getInt("mandantid");
			user.lastname = rs.getString("name");
			user.firstname = rs.getString("firstname");
			user.email = rs.getString("email");
		
		}
		return user;
	}
		
		public Mandants getmandants(Integer id) throws SQLException {
			if (!connected)
				connect();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM mandants where mandantid ="+ id);
			Mandants  mandants= new Mandants();
			while (rs.next() ) {
				mandants.mandantid = rs.getInt("mandantid");
				mandants.zip = rs.getInt("zip");
				mandants.name = rs.getString("name");
				mandants.address = rs.getString("address");
				mandants.city = rs.getString("city");
				mandants.state = rs.getString("state");
				mandants.country = rs.getString("country");
		
				


	}
			return mandants;
		}
		public Mandantuser getmandantuser(Integer id) throws SQLException {
			if (!connected)
				connect();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM mandantuser where mandantuser ="+ id);
			Mandantuser mandantuser = new Mandantuser();
			while (rs.next() ) {
				mandantuser.mandantid = rs.getInt("mandantid");
				mandantuser.userid	  = rs.getInt("userid");
			}
			return mandantuser;
		}
	
		public Projects getprojects(Integer id) throws SQLException {
			if (!connected)
				connect();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM projects where projectid ="+ id);
			Projects projects= new Projects();
			while (rs.next() ) {
				projects.projectid = rs.getInt("projectid");
				projects.mandantid = rs.getInt("mandantid");
				projects.time = rs.getInt("time");
				projects.name = rs.getString("name");
				
			}
			return projects;
				
				
}
		public Tasks gettasks(Integer id) throws SQLException {
			if (!connected)
				connect();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM tasks where taskid ="+ id);
			Tasks tasks= new Tasks();
			while (rs.next() ) {
				tasks.taskid = rs.getInt("taskid");
				tasks.name = rs.getString("name");
				tasks.pph = rs.getString("pph");
}
			return tasks;

		}

		public Timelices gettimeslices(Integer id) throws SQLException {
			if (!connected)
				connect();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM timeslices where taskid ="+ id);
			Timelices timeslices= new Timelices();
			while (rs.next() ) {
				timeslices.taskid = rs.getInt("taskid");
				timeslices.userid = rs.getInt("userid");
				timeslices.startts = rs.getInt("startts");
				timeslices.endts = rs.getInt("endts");
				timeslices.comment = rs.getString("text");
			}
			return timeslices;
			
		
		}
}




