package com.lhs.domain;



/**
 * Task entity. @author MyEclipse Persistence Tools
 */

public class Task  implements java.io.Serializable {


    // Fields    

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


    // Constructors

    /** default constructor */
    public Task() {
    }

    
    /** full constructor */
    public Task(String taskId, String taskName, String startTime, 
    		String endTme, String founderId, String founder, 
    		String emploeeId, String employeeName, String percentage, 
    		String satisfaction, String audtime, String goal, 
    		String type, Integer grade, String fenId, String fener, 
    		String fenTime, String content, String audcontent,String audtype) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.startTime = startTime;
        this.endTme = endTme;
        this.founderId = founderId;
        this.founder = founder;
        this.emploeeId = emploeeId;
        this.employeeName = employeeName;
        this.percentage = percentage;
        this.satisfaction = satisfaction;
        this.audtime = audtime;
        this.goal = goal;
        this.type = type;
        this.grade = grade;
        this.fenId = fenId;
        this.fener = fener;
        this.fenTime = fenTime;
        this.content = content;
        this.audcontent = audcontent;
        this.audtype = audtype;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaskId() {
        return this.taskId;
    }
    
    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return this.taskName;
    }
    
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getStartTime() {
        return this.startTime;
    }
    
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTme() {
        return this.endTme;
    }
    
    public void setEndTme(String endTme) {
        this.endTme = endTme;
    }

    public String getFounderId() {
        return this.founderId;
    }
    
    public void setFounderId(String founderId) {
        this.founderId = founderId;
    }

    public String getFounder() {
        return this.founder;
    }
    
    public void setFounder(String founder) {
        this.founder = founder;
    }

    public String getEmploeeId() {
        return this.emploeeId;
    }
    
    public void setEmploeeId(String emploeeId) {
        this.emploeeId = emploeeId;
    }

    public String getEmployeeName() {
        return this.employeeName;
    }
    
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getPercentage() {
        return this.percentage;
    }
    
    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public String getSatisfaction() {
        return this.satisfaction;
    }
    
    public void setSatisfaction(String satisfaction) {
        this.satisfaction = satisfaction;
    }

    public String getAudtime() {
        return this.audtime;
    }
    
    public void setAudtime(String audtime) {
        this.audtime = audtime;
    }

    public String getGoal() {
        return this.goal;
    }
    
    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }

    public Integer getGrade() {
        return this.grade;
    }
    
    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getFenId() {
        return this.fenId;
    }
    
    public void setFenId(String fenId) {
        this.fenId = fenId;
    }

    public String getFener() {
        return this.fener;
    }
    
    public void setFener(String fener) {
        this.fener = fener;
    }

    public String getFenTime() {
        return this.fenTime;
    }
    
    public void setFenTime(String fenTime) {
        this.fenTime = fenTime;
    }

    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }

    public String getAudcontent() {
        return this.audcontent;
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