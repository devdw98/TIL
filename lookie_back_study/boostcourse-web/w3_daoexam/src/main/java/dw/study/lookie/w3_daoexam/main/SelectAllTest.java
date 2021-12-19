package dw.study.lookie.w3_daoexam.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dw.study.lookie.w3_daoexam.config.ApplicationConfig;
import dw.study.lookie.w3_daoexam.dao.RoleDao;
import dw.study.lookie.w3_daoexam.dto.Role;

public class SelectAllTest {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		RoleDao dao = ac.getBean(RoleDao.class);
		List<Role> list = dao.selectAll();
		for(Role role:list) {
			System.out.println(role);
		}
		
	}
}
