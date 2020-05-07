package dw.study.lookie.w2_webapiexam.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import dw.study.lookie.w2_jdbcexam.dao.RoleDao;
import dw.study.lookie.w2_jdbcexam.dto.Role;

@WebServlet("/roles")
public class RolesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RolesServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		
		RoleDao dao = new RoleDao();
		List<Role> list = dao.getRoles();
		
		ObjectMapper objectMapper = new ObjectMapper(); //json 문자열로 바꾸거나 json 문자열을 객체로 바꾸는 역할을 수행하는 객체
		String json = objectMapper.writeValueAsString(list);
		
		System.out.println(json);
		PrintWriter out = response.getWriter();
		out.println(json);
//		out.println(list);
		out.close();
		
	}


}
