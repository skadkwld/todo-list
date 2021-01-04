package limuiju.todolist.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

@WebServlet("/todo")
public class TodoController extends HttpServlet {
       
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
		request.setAttribute("msgId", request.getParameter("msgId"));
		
		request
		.getRequestDispatcher("todo/listTodo.jsp")
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String todoDate = request.getParameter("todoDate");
		String userId = "eoaudehd0818@naver.com";
		
		String url = "jdbc:oracle:thin:@127.0.0.1:1521/xe";
		String sql 
		= "insert into todos(user_id, title, todo_date) "
				+ "values (?,?,?)";
		
		int result = 0;
		
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
		
		if(result > 0) {
			response.sendRedirect("todo?msgId=111");
		} else {
			response.sendRedirect("todo?msgId=110");
		}
		
		//response.sendRedirect("todo");
	}

}
