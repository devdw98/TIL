package kr.or.connect.roleapp;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.Assert;
import kr.or.connect.roleapp.dto.Role;
import kr.or.connect.roleapp.service.RoleService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleServiceTest {
	@Autowired
	RoleService roleService;

	@Test
	public void getRoles() throws Exception {
		List<Role> roles = roleService.getRoles();
		Assert.assertEquals(roles.size(), 3);
	}
}
