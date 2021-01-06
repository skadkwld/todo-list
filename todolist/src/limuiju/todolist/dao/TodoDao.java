package limuiju.todolist.dao;

import java.util.List;

import limuiju.todolist.domain.Todo;

public interface TodoDao {
	List<Todo> selectTodoList();
	Todo selectTodo(String todoNum);
	int insertTodo(String title, String todoDate, String userId);
	int updateTodo(String title, String todoDate, String todoNum);
	int deleteTodo(String todoNum);
}
