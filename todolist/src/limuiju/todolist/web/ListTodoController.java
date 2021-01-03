package limuiju.todolist.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import limuiju.todolist.domain.Todo;
import limuiju.todolist.util.MyParam;

@WebServlet("/todo/listTodo")
public class ListTodoController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String url = "jdbc:oracle:thin:@127.0.0.1:1521/xe";
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
		
		request.setAttribute("todoList", todoList);
		
		request
		.getRequestDispatcher("/todo/listTodo.jsp")
		.forward(request, response);
		
	}
}
