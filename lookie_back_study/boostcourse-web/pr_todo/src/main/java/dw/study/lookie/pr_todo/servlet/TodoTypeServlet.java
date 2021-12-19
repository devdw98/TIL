package dw.study.lookie.pr_todo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dw.study.lookie.pr_todo.dao.TodoDao;
import dw.study.lookie.pr_todo.dto.TodoDto;

/**
 * Servlet implementation class TodoTypeServlet
 */
public class TodoTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public TodoTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		//메인화면에서 todo 상태변경버튼(->)을 클릭하면 
		//TodoTypeServlet에게 Todo 의 Id와 상태 값을 전달하여 
		//다음 상태로 (현재 상태가 TODO라면 DOING으로 DOING 이라면 DONE로) TodoDao를 이용해서 변경합니다.
		
	}

}
