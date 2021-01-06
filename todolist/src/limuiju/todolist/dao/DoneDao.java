package limuiju.todolist.dao;

import java.util.List;

import limuiju.todolist.domain.Done;

public interface DoneDao {
	List<Done> selectDoneList();
	int insertDone(String userId,String doneDate, String title);
}
