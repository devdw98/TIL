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
		//����ȭ�鿡�� todo ���º����ư(->)�� Ŭ���ϸ� 
		//TodoTypeServlet���� Todo �� Id�� ���� ���� �����Ͽ� 
		//���� ���·� (���� ���°� TODO��� DOING���� DOING �̶�� DONE��) TodoDao�� �̿��ؼ� �����մϴ�.
		
	}

}
