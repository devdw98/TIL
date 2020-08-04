package kr.or.connect.roleapp;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.Assert;
import kr.or.connect.roleapp.dao.RoleDao;
import kr.or.connect.roleapp.dto.Role;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleDaoTest {
	@Autowired
	RoleDao dao;

	@Test
	public void selectAll() throws Exception {
		List<Role> roles = dao.selectAll();
		Assert.assertEquals(roles.size(), 3);
		for(Role r:roles) {
			System.out.println(r);
		}
	}
}
