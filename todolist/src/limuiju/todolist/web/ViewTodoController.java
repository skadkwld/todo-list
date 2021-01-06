package limuiju.todolist.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import limuiju.todolist.dao.TodoDao;
import limuiju.todolist.dao.TodoDaoImpl;
import limuiju.todolist.domain.Todo;

@WebServlet("/todo/viewTodo")
public class ViewTodoController extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		TodoDao todoDao = new TodoDaoImpl();
		String todoNum = request.getParameter("todoNum");
		
		Todo todo = todoDao.selectTodo(todoNum);
		
		request.setAttribute("todo", todo);
		
		request
		.getRequestDispatcher("viewTodo.jsp")
		.forward(request, response);
	}

}
