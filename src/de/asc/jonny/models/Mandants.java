/**
 * 
 */
package de.asc.jonny.models;

/**
 * @author jonas
 *
 */
public class Mandants {
	public Integer mandantid = null;
	public String name = null;
	public String address = null;
	public Integer zip = null;
	public String city = null;
	public String state = null;
	public String country = null;

	public 	Mandants(Integer mandantid,String name, String address,Integer zip, String city, String state, String country) {
		this.mandantid = mandantid;
		this.name = name;
		this.address = address;
		this.zip = zip;
		this.city = city;
		this.state = state; 
		this.country = country;
	}

	public Mandants() {
		// TODO Auto-generated constructor stub
	}

	
}