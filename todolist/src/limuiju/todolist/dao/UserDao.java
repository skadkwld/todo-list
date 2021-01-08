package limuiju.todolist.dao;

import limuiju.todolist.domain.User;

public interface UserDao {
	int login(String userId, String userPw);
	int join(User user);
	String getUserEmailChecked(String userId);
	int setUserEmailChecked(String userId);
	String getUserEmail(String userId);
}
