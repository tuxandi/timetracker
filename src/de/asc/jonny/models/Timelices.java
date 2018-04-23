package de.asc.jonny.models;

public class Timelices {

	public Integer taskid;
	public Integer userid;
	public Integer startts;
	public Integer endts;
	public String comment;

	
	public Timelices(Integer taskid, Integer userid, Integer startts, Integer endts, String comment) {
		this.taskid = taskid;
		this.userid = userid;
		this.startts = startts;
		this.endts = endts;
		this.comment = comment;
		
	}


	public Timelices() {
		// TODO Auto-generated constructor stub
	}
}
