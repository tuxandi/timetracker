/**
 * 
 */
package de.asc.jonny.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import de.asc.jonny.models.Mandants;
import de.asc.jonny.models.Mandantuser;
import de.asc.jonny.models.User;

/**
 * @author jonas
 *
 */
public class TimePro {



	/**
	 * 
	 */
	public TimePro() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {


		TimeProDB timeProDB = new TimeProDB();
		User exampleUser = timeProDB.getUser(12);
		System.out.println(exampleUser.lastname);
		Mandants exampleMandants = timeProDB.getmandants(3121577);
		System.out.println(exampleMandants.name);
		//Mandantuser exampleMandantuser = timeProDB.getmandantuser(1);
		//System.out.println(exampleMandantuser.mandantid);
	}


}


