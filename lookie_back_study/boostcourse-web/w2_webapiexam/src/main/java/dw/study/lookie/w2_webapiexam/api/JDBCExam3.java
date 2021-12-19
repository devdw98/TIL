package dw.study.lookie.w2_webapiexam.api;

import java.util.List;

import dw.study.lookie.w2_jdbcexam.dao.RoleDao;
import dw.study.lookie.w2_jdbcexam.dto.Role;

public class JDBCExam3 {
	public static void main(String[] args) {
		RoleDao dao = new RoleDao();
		List<Role> list = dao.getRoles();
		
		for(Role role:list) {
			System.out.println(role);
		}
	}
}
