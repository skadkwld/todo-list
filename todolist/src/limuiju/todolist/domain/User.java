package limuiju.todolist.domain;

public class User {
	private String userId;
	private String userPw;
	private String userEmail;
	private String userEmamilHash;
	private String userEmailChecked;
	
	public User() {}

	public User(String userId, String userPw, String userEmail, String userEmamilHash, String userEmailChecked) {
		this.userId = userId;
		this.userPw = userPw;
		this.userEmail = userEmail;
		this.userEmamilHash = userEmamilHash;
		this.userEmailChecked = userEmailChecked;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserEmamilHash() {
		return userEmamilHash;
	}

	public void setUserEmamilHash(String userEmamilHash) {
		this.userEmamilHash = userEmamilHash;
	}

	public String getUserEmailChecked() {
		return userEmailChecked;
	}

	public void setUserEmailChecked(String userEmailChecked) {
		this.userEmailChecked = userEmailChecked;
	}
	
}
