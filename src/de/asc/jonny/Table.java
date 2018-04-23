package de.asc.jonny;
import java.sql.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Table {

	public Table() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Connection c = null;
    Statement stmt = null;
    try {
    	Class.forName("org.postgresql.Driver");
    	c = DriverManager
    	.getConnection("jdbc:postgresql://localhost:5432/timetracker","time", "jonas");
    	System.out.println("Verbindung zur DB erfolgreich");
    	
    	stmt = c.createStatement();
    	String sql = "CREATE TABLE ? " +
    	"(?????)";
    	stmt.executeUpdate(sql);
    	stmt.close();
    } catch (Exception e) {
    	System.err.println(e.getClass().getName()+": "+ e.getMessage() );
    	System.exit(0);
    }
	System.out.println("Tabelle wurde erfolgreich erstellt");
	}

}
