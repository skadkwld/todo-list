package limuiju.todolist.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import limuiju.todolist.dao.TodoDao;
import limuiju.todolist.dao.TodoDaoImpl;
import limuiju.todolist.domain.Todo;

@WebServlet("/todo")
public class TodoController extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		TodoDao todoDao = new TodoDaoImpl();
		List<Todo> todoList = todoDao.selectTodoList();
				
		request.setAttribute("todoList", todoList);
		request.setAttribute("job", 1);
		request.setAttribute("msgId", request.getParameter("msgId"));
		
		request
		.getRequestDispatcher("todo/listTodo.jsp")
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String todoDate = request.getParameter("todoDate");
		String userId = (String)request.getSession()
					.getAttribute("userId");
		
		TodoDao todoDao = new TodoDaoImpl();
		
		int result = todoDao.insertTodo(title, todoDate, userId);
		
		if(result > 0) {
			response.sendRedirect("todo?msgId=111");
		} else {
			response.sendRedirect("todo?msgId=110");
		}
		
	}
}
