package limuiju.todolist.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/todo/delTodo")
public class DelTodoController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String todoNum = request.getParameter("todoNum");
		
		String url = "jdbc:oracle:thin:@127.0.0.1:1521/xe";
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
		//Cookie[] cookie = request.getCookies();
		//HttpSession session = request.getSession();
		//session.setAttribute("msg", "할일 삭제 성공하였습니다.");
		
		response.sendRedirect("../todo?msgId=131");
	}
}
