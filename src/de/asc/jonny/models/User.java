/**
 * 
 */
package de.asc.jonny.models;

/**
 * @author jonas
 *
 */
public class User {
	public Integer userid = null;
	public Integer id = null; 
	public Integer mandantid = null;
	public String lastname = null; 
	public String firstname = null;
	public String name = null;
	public String email;
	
	
	
	
	/**
	 * 
	 */
	public User(Integer userid,Integer mandantid, String name,String firstname, String email) {
		this.userid = userid;
		this.mandantid = mandantid;
		this.name = name;
		this.email = email;
		this.firstname = firstname;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

}
