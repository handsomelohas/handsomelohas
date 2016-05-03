package com.lhs.struts.form;

import org.apache.struts.action.ActionForm;

public class TaskForm extends ActionForm {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 private Integer id;
     private String taskId;
     private String taskName;
     private String startTime;
     private String endTme;
     private String founderId;
     private String founder;
     private String emploeeId;
     private String employeeName;
     private String percentage;
     private String satisfaction;
     private String audtime;
     private String goal;
     private String type;
     private Integer grade;
     private String fenId;
     private String fener;
     private String fenTime;
     private String content;
     private String audcontent;
     private String audtype;
     
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTme() {
		return endTme;
	}
	public void setEndTme(String endTme) {
		this.endTme = endTme;
	}
	public String getFounderId() {
		return founderId;
	}
	public void setFounderId(String founderId) {
		this.founderId = founderId;
	}
	public String getFounder() {
		return founder;
	}
	public void setFounder(String founder) {
		this.founder = founder;
	}
	public String getEmploeeId() {
		return emploeeId;
	}
	public void setEmploeeId(String emploeeId) {
		this.emploeeId = emploeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getPercentage() {
		return percentage;
	}
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	public String getSatisfaction() {
		return satisfaction;
	}
	public void setSatisfaction(String satisfaction) {
		this.satisfaction = satisfaction;
	}
	public String getAudtime() {
		return audtime;
	}
	public void setAudtime(String audtime) {
		this.audtime = audtime;
	}
	public String getGoal() {
		return goal;
	}
	public void setGoal(String goal) {
		this.goal = goal;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public String getFenId() {
		return fenId;
	}
	public void setFenId(String fenId) {
		this.fenId = fenId;
	}
	public String getFener() {
		return fener;
	}
	public void setFener(String fener) {
		this.fener = fener;
	}
	public String getFenTime() {
		return fenTime;
	}
	public void setFenTime(String fenTime) {
		this.fenTime = fenTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAudcontent() {
		return audcontent;
	}
	public void setAudcontent(String audcontent) {
		this.audcontent = audcontent;
	}
	public String getAudtype() {
		return audtype;
	}
	public void setAudtype(String audtype) {
		this.audtype = audtype;
	}
    
	
}
