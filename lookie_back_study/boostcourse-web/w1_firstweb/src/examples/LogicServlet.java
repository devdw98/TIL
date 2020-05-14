package examples;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogicServlet
 */
@WebServlet("/logic")
public class LogicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogicServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int v1 = (int) (Math.random() * 100) + 1;
		int v2 = (int) (Math.random() * 100) + 1;
		int result = v1 + v2;

		//jsp에서 쓰기 위해 결과값을 보낸다!
		request.setAttribute("v1", v1);
		request.setAttribute("v2", v2);
		request.setAttribute("result", result);
		
		//forward 하기 위한 것
		RequestDispatcher rd = request.getRequestDispatcher("/redirect_ex/result.jsp");
		rd.forward(request, response);
		
		
		//logic은 servlet이, 응답결과는 jsp가 하게 한다!
		//forward로 받았기 때문에 url은 바뀌지 않는다
	}

}
