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

@WebServlet("/todo/addTodo")
public class AddTodoController extends HttpServlet {
	
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
			request.setAttribute("msg","할일 추가 성공하였습니다.");
		} else {
			request.setAttribute("msg","할일 추가 실패하였습니다.");
		}
		
		response.sendRedirect("listTodo");
	}

}
