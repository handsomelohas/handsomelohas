package com.lhs.domain;

import java.util.Set;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */

public class Users implements java.io.Serializable {

	private String userId;
	private String userName;
	private String password;
	private String position;
	private Integer age;
	private String sex;
	private String indate;
	private String deport;
	private String role;
	
	private Set<Message> sendMessage;
    private Set<Message> getMessage;

	// Constructors

	/** default constructor */
	public Users() {
	}

	/** full constructor */
	public Users(String userId,String userName, String password, String position,
			Integer age, String sex, String indate, String deport, String role) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.position = position;
		this.age = age;
		this.sex = sex;
		this.indate = indate;
		this.deport = deport;
		this.role = role;
	}

	// Property accessors

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIndate() {
		return this.indate;
	}

	public void setIndate(String indate) {
		this.indate = indate;
	}

	public String getDeport() {
		return this.deport;
	}

	public void setDeport(String deport) {
		this.deport = deport;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	//пео╒
	public Set<Message> getSendMessage() {
		return sendMessage;
	}

	public void setSendMessage(Set<Message> sendMessage) {
		this.sendMessage = sendMessage;
	}

	public Set<Message> getGetMessage() {
		return getMessage;
	}

	public void setGetMessage(Set<Message> getMessage) {
		this.getMessage = getMessage;
	}
	
}