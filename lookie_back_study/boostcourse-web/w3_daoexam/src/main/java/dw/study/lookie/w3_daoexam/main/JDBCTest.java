package dw.study.lookie.w3_daoexam.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dw.study.lookie.w3_daoexam.config.ApplicationConfig;
import dw.study.lookie.w3_daoexam.dao.RoleDao;
import dw.study.lookie.w3_daoexam.dto.Role;

public class JDBCTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		RoleDao dao = ac.getBean(RoleDao.class);
		
		Role role = new Role();
		role.setRoleId(102);
		role.setDescription("CEO");
		
		System.out.println(role.getRoleId()+" "+role.getDescription());
//		
//		int count = dao.insert(role);
//		System.out.println(count+" 입력했습니다.");
		
		int count = dao.update(role);
		System.out.println(count + "수정되었습니다.");
	}

}
