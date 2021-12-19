package dw.study.lookie.w2_jdbcexam;

import dw.study.lookie.w2_jdbcexam.dao.RoleDao;
import dw.study.lookie.w2_jdbcexam.dto.Role;

public class JDBCExam_update {
	public static void main(String[] args) {
		int roleId = 500;
		String description_new = "CEO";
		
		Role role = new Role(roleId, description_new);
		
		RoleDao dao = new RoleDao();
		int updateCount = dao.updateRole(role);
		System.out.println(updateCount);
		
	}
}
