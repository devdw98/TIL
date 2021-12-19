package dw.study.lookie.pr_todo.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dw.study.lookie.pr_todo.dao.TodoDao;
import dw.study.lookie.pr_todo.dto.TodoDto;

//@WebServlet("/main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TodoDao dao = new TodoDao();
		List<TodoDto> list = dao.getTodos();
		List<TodoDto> todos = new ArrayList<>();
		List<TodoDto> doings = new ArrayList<>();
		List<TodoDto> dones = new ArrayList<>();
		
		for(TodoDto dto : list) {
//			System.out.println(dto);
			if(dto.getType().equals("TODO"))
				todos.add(dto);
			else if(dto.getType().equals("DOING")) {
				doings.add(dto);
			}
			else {
				dones.add(dto);
			}
		}

		ServletContext sc = this.getServletContext();
//		request.setAttribute("todolist", list);
		request.setAttribute("todo", todos);
		request.setAttribute("doing", doings);
		request.setAttribute("done", dones);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/main.jsp");
		rd.forward(request, response);
		
		
	}
}
