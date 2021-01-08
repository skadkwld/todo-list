package limuiju.todolist.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import limuiju.todolist.dao.DoneDao;
import limuiju.todolist.dao.DoneDaoImpl;
import limuiju.todolist.dao.TodoDao;
import limuiju.todolist.dao.TodoDaoImpl;
import limuiju.todolist.domain.Done;

@WebServlet("/done")
public class DoneController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		DoneDao doneDao = new DoneDaoImpl();
		List<Done> doneList = doneDao.selectDoneList();
				
		request.setAttribute("doneList", doneList);
		request.setAttribute("job", 2);
		request.setAttribute("msgId", request.getParameter("msgId"));
		
		request
		.getRequestDispatcher("done/listDone.jsp")
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String todoNum = request.getParameter("todoNum");
		String doneDate = request.getParameter("todoDate");
		String userId = (String) request.getSession()
				.getAttribute("userId");
		
		TodoDao todoDao = new TodoDaoImpl();
		DoneDao doneDao = new DoneDaoImpl();
		
		todoDao.deleteTodo(todoNum);
		int result = doneDao.insertDone(userId,doneDate,title);
		
		if(result > 0) {
			response.sendRedirect("done?msgId=211");
		} else {
			response.sendRedirect("done?msgId=210");
		}
	}

}
