package dw;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/today")
public class TodayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TodayServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LocalDateTime ltime = LocalDateTime.now();
		
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println("<a href= "+"index.html"+"> 메인화면</a>");
		out.println("<h1>현재시간 : "+ltime.getYear()
		+"/"+ltime.getMonthValue()+"/"+ltime.getDayOfMonth()+" "+
				ltime.getHour()+":"+ltime.getMinute()+"</h1>");
		
	}

}
