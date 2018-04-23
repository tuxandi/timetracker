package de.asc.jonny;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Select {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/timetracker",
							"time", "jonas"	);
			c.setAutoCommit(false);
			System.out.println("Verbindung mit Datenbank erfolgreich"+"\n");

			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM mandants ;");
			while (rs.next() ) {
				int mandantid = rs.getInt("mandantid");
				String name = rs.getString("name");
				String address = rs.getString("address");
				int zip = rs.getInt("zip");
				String city = rs.getString("city");
				String state = rs.getString("state");
				String country = rs.getString("country");

				System.out.println(mandantid);
				System.out.println(name);
				System.out.println(address);
				System.out.println(zip);
				System.out.println(city);
				System.out.println(state);
				System.out.println(country);

				System.out.println("_______________________________");
			}

			rs.close();
			stmt.close();
			c.close();

		} catch (Exception e) {
			System.err.println(e.getClass().getName()+". "+ e.getLocalizedMessage());
			System.exit(0);


		}
		System.out.println("Aufgabe erledigt");
	}
}
