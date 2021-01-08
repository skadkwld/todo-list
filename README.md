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

##### 👉 리소스 별로 폴더를 구분하여 관리하였습니다 
<img src="https://user-images.githubusercontent.com/49936855/103998291-3db8a500-51df-11eb-9c39-d8691f7d1655.png"/>

#### 1. 로그인

<img width="400" src="https://user-images.githubusercontent.com/49936855/103997199-1e6d4800-51de-11eb-99ca-bd8110d55aa8.png"/>

#### 2. 회원가입

<img width="400" src="https://user-images.githubusercontent.com/49936855/104005205-1e724580-51e8-11eb-9097-97886f6483af.png"/>
 - 이메일 인증 후 회원가입 완료

#### 2. 할일 추가

<img width="400" src="https://user-images.githubusercontent.com/49936855/104003636-01d50e00-51e6-11eb-8575-8e779e021182.png"/>

<img width="400" src="https://user-images.githubusercontent.com/49936855/104003062-457b4800-51e5-11eb-9e62-bdfa1f481b1a.png"/>

#### 3. 할일 수정

<img width="400" src="https://user-images.githubusercontent.com/49936855/104004010-93dd1680-51e6-11eb-8951-f98e62c1601c.png"/>

<img width="400" src="https://user-images.githubusercontent.com/49936855/104004167-c555e200-51e6-11eb-88a9-1450819dd355.png"/>

#### 4. 할일 삭제

<img width="400" src="https://user-images.githubusercontent.com/49936855/104004292-eb7b8200-51e6-11eb-9866-a79450422c05.png"/>

<img width="400" src="https://user-images.githubusercontent.com/49936855/104004442-1b2a8a00-51e7-11eb-92bb-666716b2be9b.png"/>

#### 5. 할일 완료 

<img width="400" src="https://user-images.githubusercontent.com/49936855/104004886-a441c100-51e7-11eb-943a-fe8237d5bfea.png"/>

<img width="400" src="https://user-images.githubusercontent.com/49936855/104005111-fa166900-51e7-11eb-9ed2-9e60dbb8bd7f.png"/>
