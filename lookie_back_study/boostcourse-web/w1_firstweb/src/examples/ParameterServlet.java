package examples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/param")
public class ParameterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ParameterServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>form</title></head>");
		out.println("<body>");
		//파라미터에 값 넣어서 요청 보내기
		String name = request.getParameter("name"); 
		String age = request.getParameter("age");
		//응답결과
		out.println("name : " + name + "<br>");
		out.println("age : " + age + "<br>");

		out.println("</body>");
		out.println("</html>");
	}

}
