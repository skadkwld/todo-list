package limuiju.todolist.domain;

import java.sql.Date;
import java.time.LocalDate;

public class Todo {
	private int todoNum;
	private String userId;
	private String title;
	private Date todoDate;
	
	public Todo() {}
	
	public Todo(int todoNum, String userId, String title, Date todoDate) {
		this.todoNum = todoNum;
		this.userId = userId;
		this.title = title;
		this.todoDate = todoDate;
	}
	
	public int getTodoNum() {
		return todoNum;
	}
	
	public void setTodoNum(int todoNum) {
		this.todoNum = todoNum;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public Date getTodoDate() {
		return todoDate;
	}

	public void setTodoDate(Date todoDate) {
		this.todoDate = todoDate;
	}
}
