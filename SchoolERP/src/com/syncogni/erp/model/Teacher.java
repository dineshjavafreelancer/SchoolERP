package com.syncogni.erp.model;

public class Teacher {

	private int id;
	private String Name;
    private String subject;
    private String Address;
    
    public Teacher(){}
    public Teacher(int id,String Name,String subject,String Address){
    	super();
    	this.id=id;
    	this.Name=Name;
    	this.subject=subject;
    	this.Address=Address;
  }

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
    

}
