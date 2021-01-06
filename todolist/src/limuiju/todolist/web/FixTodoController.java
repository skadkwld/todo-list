package limuiju.todolist.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import limuiju.todolist.dao.TodoDao;
import limuiju.todolist.dao.TodoDaoImpl;

@WebServlet("/todo/fixTodo")
public class FixTodoController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String title = request.getParameter("title");
		String todoDate = request.getParameter("todoDate");
		String todoNum = request.getParameter("todoNum");
		
		TodoDao todoDao = new TodoDaoImpl();
		
		int result = todoDao.updateTodo(title, todoDate, todoNum);
		
		if(result > 0) {
			response.sendRedirect("../todo?msgId=121");
		}else {
			response.sendRedirect("../todo?msgId=120");
		}
		
	}
}
	
