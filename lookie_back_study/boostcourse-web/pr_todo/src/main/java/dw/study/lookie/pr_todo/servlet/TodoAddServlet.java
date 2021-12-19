package dw.study.lookie.pr_todo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dw.study.lookie.pr_todo.dao.TodoDao;
import dw.study.lookie.pr_todo.dto.TodoDto;

/**
 * Servlet implementation class TodoAddServlet
 */
public class TodoAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TodoAddServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		super.doGet(req, resp);
//		
//	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		TodoDao dao = new TodoDao();
		TodoDto dto = (TodoDto)req.getAttribute("newTodo");
		System.out.println(dto);
		int insertCount = dao.addTodo(dto);
		if(insertCount == 1) {
			resp.sendRedirect("/pr_todo/main");
		}else {
			resp.sendRedirect("/todoForm");
		}	
	}
	
	

}
