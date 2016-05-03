package com.lhs.domain;

/**
 * Empoyee entity. @author MyEclipse Persistence Tools
 */

public class Employee implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String employeeId;
	private String employeeName;
	private String password;
	private String position;
	private int age;
	private String sex;
	private String intime;
	private String deport;

	// Constructors

	/** default constructor */
	public Employee() {
	}

	/** minimal constructor */
	public Employee(String employeeId) {
		this.employeeId = employeeId;
	}

	/** full constructor */
	public Employee(String employeeId, String employeeName, String password,
			String position, int age, String sex, String intime,
			String deport) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.password = password;
		this.position = position;
		this.age = age;
		this.sex = sex;
		this.intime = intime;
		this.deport = deport;
	}

	// Property accessors

	public String getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return this.employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIntime() {
		return intime;
	}

	public void setIntime(String intime) {
		this.intime = intime;
	}

	public String getDeport() {
		return this.deport;
	}

	public void setDeport(String deport) {
		this.deport = deport;
	}

}