package limuiju.todolist.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import limuiju.todolist.domain.Todo;

@WebServlet("/todo/viewTodo")
public class ViewTodoController extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		Todo todo = new Todo();
		String todoNum = request.getParameter("todoNum");
		
		String url = "jdbc:oracle:thin:@127.0.0.1:1521/xe";
		String sql = "select * from todos where todo_num ='" + todoNum + "' ";
		
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
		
		request.setAttribute("todo", todo);
		
		request
		.getRequestDispatcher("viewTodo.jsp")
		.forward(request, response);
	}

}
