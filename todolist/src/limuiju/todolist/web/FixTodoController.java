package limuiju.todolist.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/todo/fixTodo")
public class FixTodoController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String title = request.getParameter("title");
		String todoDate = request.getParameter("todoDate");
		String todoNum_ = request.getParameter("todoNum");
		String url = "jdbc:oracle:thin:@127.0.0.1:1521/xe";
		String sql = "update todos set title = ?, todo_date = ? where todo_num = ?";
		
		int userNum = 0;
		int result = 0;
		
		if(todoNum_ != null && !todoNum_.equals("")) 
			userNum = Integer.parseInt(todoNum_);
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,"todo","todo");
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1,title);
			st.setString(2, todoDate);
			st.setString(3, todoNum_);
			
			result = st.executeUpdate();
			
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(result > 0) {
			response.sendRedirect("../todo?msgId=121");
		}else {
			response.sendRedirect("../todo?msgId=120");
		}
		
		//response.sendRedirect("../todo");
	}
}
	
