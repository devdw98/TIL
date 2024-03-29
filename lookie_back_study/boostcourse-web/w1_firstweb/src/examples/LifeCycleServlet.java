package examples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//w1-4-7 Servlet LifeCycle 실습코드
@WebServlet("/LifeCycleServlet")
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LifeCycleServlet() {
		System.out.println("LifeCycleServlet 생성!");
	}

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 호출!");
	}

	public void destroy() {
		System.out.println("destroy 호출!");
	}

//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	System.out.println("service 호출!");
//}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head><title>form</title></head>");
		out.println("<body>");
		out.println("<form method='post' action='/w1_firstweb/LifeCycleServlet'>");//submit 요청 시 action URL에 Post 방식으로 요청해주세요
		out.println("name : <input type='text' name='name'><br>");
		out.println("<input type='submit' value='ok'><br>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String name = req.getParameter("name");
		out.println("<h1> hello " + name + "</h1>");
		out.close();
	}

}
