package dw.study.lookie.w2_jdbcexam;

import dw.study.lookie.w2_jdbcexam.dao.RoleDao;

public class JDBCExam_delete {
	public static void main(String[] args) {
		int roleId = 500;
		
		RoleDao dao = new RoleDao();
		int deleteCount = dao.deleteRole(roleId);
		System.out.println(deleteCount);
	}

}
