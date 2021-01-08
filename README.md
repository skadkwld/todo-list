## todo-list

###  개발도구 : java, jsp, orcle, jdbc, html, css, bootstrap

###  목적 : jsp 복습, 디자인 패턴 활용, 이메일 인증 기능 학습

###  디자인패턴 : mvc2 패턴 ( 로그인 기능은 유튜브 보며 따라한 것이라 제외 )

###  세부사항

#### 0. 프로그램 구조
##### 👉 web 패키지에서 *controller 클래스(서블릿)을 사용하여 뷰와 모델,컨트롤러를 분리하여  mvc2 패턴 적용해봤습니다.

<img src="https://user-images.githubusercontent.com/49936855/103997427-67bd9780-51de-11eb-871d-26d02f6dfa0d.png"/>

```java

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
```
##### 👉 예시로 TodoController 코드입니다. 이 컨트롤러와 jsp를 분리시켜 스파게티코드를 없애는데 집중했습니다. 
##### 👉 /todo에 get 요청이오면 리스트를 보여주고 post 요청이오면 

##### 👉 리소스 별로 폴더를 구분하여 관리하였습니다 ( user 폴더는 유튜브를 보며 이메일 인증 로그인을 따라하였고 mvc2 패턴을 적용하지 못했습니다 ).
<img src="https://user-images.githubusercontent.com/49936855/103998291-3db8a500-51df-11eb-9c39-d8691f7d1655.png"/>

#### 1. 로그인

<img src="https://user-images.githubusercontent.com/49936855/103997199-1e6d4800-51de-11eb-99ca-bd8110d55aa8.png" style="width=150px"/>

#### 2. 할일 추가
#### 3. 할일 수정
#### 4. 할일 삭제
#### 5. 할일 완료 

