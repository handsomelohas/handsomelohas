package com.entity;

public class Person {
	
	private int pid;
	private String pname;
	private String sex;
	private String password;
	private String address;
	
	public Person(){
		
	}
	
	public Person(int pid, String pname, String sex, String password,
			String address) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.sex = sex;
		this.password = password;
		this.address = address;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
