package dw.study.lookie.w2_jdbcexam;

import dw.study.lookie.w2_jdbcexam.dao.RoleDao;
import dw.study.lookie.w2_jdbcexam.dto.Role;

public class JDBCExam2 {
	public static void main(String[] args) {
		int roleId = 201;
		String description = "PROGRAMMER";
		
		Role role = new Role(roleId, description);
		
		RoleDao dao = new RoleDao();
		int insertCount = dao.addRole(role);
		System.out.println(insertCount);
		
	}
}
