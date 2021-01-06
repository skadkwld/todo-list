package limuiju.todolist.domain;

import java.sql.Date;

public class Done {
	private int doneNum;
	private String userId;
	private Date doneDate;
	private String title;
	
	public Done() {}
	
	public Done(int doneNum, String userId, Date doneDate, String title) {
		this.doneNum = doneNum;
		this.userId = userId;
		this.doneDate = doneDate;
		this.title = title;
	}
	
	public int getDoneNum() {
		return doneNum;
	}
	
	public void setDoneNum(int doneNum) {
		this.doneNum = doneNum;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public Date getDoneDate() {
		return doneDate;
	}
	
	public void setDoneDate(Date doneDate) {
		this.doneDate = doneDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
