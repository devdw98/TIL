package dw.study.lookie.pr_todo.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dw.study.lookie.pr_todo.dto.TodoDto;

/**
 * Servlet implementation class TodoFormServlet
 */
//@WebServlet("/todoForm")
public class TodoFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TodoFormServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		RequestDispatcher rd = req.getRequestDispatcher("/jsp/todoForm.jsp");
		rd.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		ServletContext sc = this.getServletContext();
		req.setCharacterEncoding("UTF-8");
		String title = req.getParameter("title");
		String name = req.getParameter("name");
		int sequence = Integer.parseInt(req.getParameter("sequence"));
		System.out.println(title);
		System.out.println(name);
		System.out.println(sequence);
		
		TodoDto new_todo = new TodoDto();
		new_todo.setTitle(title);
		new_todo.setName(name);
		new_todo.setSequence(sequence);
		System.out.println(new_todo);
		req.setAttribute("newTodo", new_todo);
//		resp.sendRedirect("/todoAdd");
		RequestDispatcher rd = sc.getRequestDispatcher("/todoAdd");
		rd.forward(req, resp);
	}

}
