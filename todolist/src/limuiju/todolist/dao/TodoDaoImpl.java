package limuiju.todolist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import limuiju.todolist.domain.Todo;

public class TodoDaoImpl implements TodoDao {
	private String url = "jdbc:oracle:thin:@127.0.0.1:1521/xe";

	@Override
	public List<Todo> selectTodoList() {
		String sql = "select * from todos order by todo_date";
		
		List<Todo> todoList = new ArrayList<>();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,"todo","todo");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				Todo todo = new Todo();
				todo.setTodoNum(rs.getInt("todo_num"));
				todo.setTitle(rs.getString("title"));
				todo.setTodoDate(rs.getDate("todo_date"));
				todo.setUserId(rs.getString("user_id"));
				todoList.add(todo);
			}
				
				rs.close();
				st.close();
				con.close();
				
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return todoList;
	}

	@Override
	public Todo selectTodo(String todoNum) {
		String sql = "select * from todos where todo_num ='" + todoNum + "' ";
		Todo todo = new Todo();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,"todo","todo");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()) {
				todo.setTodoNum(rs.getInt("todo_num"));
				todo.setTitle(rs.getString("title"));
				todo.setTodoDate(rs.getDate("todo_date"));
				todo.setUserId(rs.getString("user_id"));
			}
			
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return todo;
	}

	@Override
	public int insertTodo(String title, String todoDate, String userId) {
		int result = 0;
		String sql 
		= "insert into todos(user_id, title, todo_date) "
				+ "values (?,?,?)";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,"todo","todo");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, userId);
			st.setString(2, title);
			st.setString(3, todoDate);
			
			result = st.executeUpdate();
			
			st.close();
			con.close();
				
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int updateTodo(String title, String todoDate, String todoNum) {
		String sql = "update todos set title = ?, todo_date = ? where todo_num = ?";
		
		int result = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,"todo","todo");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,title);
			st.setString(2, todoDate);
			st.setString(3, todoNum);
			
			result = st.executeUpdate();
			
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int deleteTodo(String todoNum) {
		String sql = "delete from todos where todo_num = ?";
		int result = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,"todo","todo");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, todoNum);
			
			result = st.executeUpdate();
			
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
