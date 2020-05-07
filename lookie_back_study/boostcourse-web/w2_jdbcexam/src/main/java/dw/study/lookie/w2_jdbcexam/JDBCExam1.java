package dw.study.lookie.w2_jdbcexam;

import dw.study.lookie.w2_jdbcexam.dao.RoleDao;
import dw.study.lookie.w2_jdbcexam.dto.Role;

public class JDBCExam1 {
	
	public static void main(String[] args) {
		RoleDao dao = new RoleDao();
		Role role = dao.getRole(100);
		System.out.println(role);
	}
}
