package kr.or.connect.roleapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.roleapp.dto.Role;
import kr.or.connect.roleapp.service.RoleService;

@RestController
@RequestMapping("/api/roles")
public class RoleApiController {
	@Autowired
	RoleService roleService;
	
	@GetMapping
	public List<Role> roles() throws Exception{
		return roleService.getRoles();
	}
}
