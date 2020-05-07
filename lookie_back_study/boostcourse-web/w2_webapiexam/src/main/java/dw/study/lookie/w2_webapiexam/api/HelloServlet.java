package dw.study.lookie.w2_webapiexam.api;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
//w1-4-6 HelloWorld 서블릿 컴파일 및 실행하기 실습코드
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//웹 브라우저가 서버에게 문서를 요청할 때 사용하는 방식
		//response 객체: 응답할 내용들을 모두 모아 추상화해놓은 객체
		response.setContentType("text/html;charset=UTF-8"); //컨텐츠 타입을 정해줌
		//쓸 수 있는 통로
		PrintWriter out = response.getWriter();
		out.print("<h1>Hello Servlet</h1>");
	}

}
