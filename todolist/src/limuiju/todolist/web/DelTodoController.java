package limuiju.todolist.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import limuiju.todolist.dao.TodoDao;
import limuiju.todolist.dao.TodoDaoImpl;

@WebServlet("/todo/delTodo")
public class DelTodoController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String todoNum = request.getParameter("todoNum");
		
		TodoDao todoDao = new TodoDaoImpl();
		
		int result = todoDao.deleteTodo(todoNum);
		
		if(result > 0) {
			response.sendRedirect("../todo?msgId=131");
		}else {
			response.sendRedirect("../todo?msgId=130");
		}
	}
}
