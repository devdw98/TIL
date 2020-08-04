package kr.or.connect.roleapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.connect.roleapp.service.RoleService;

@Controller
@RequestMapping("/roles")
public class RoleController {
	@Autowired
	RoleService roleService;
	
	@GetMapping
	public String roles(ModelMap modelMap) {
		modelMap.addAttribute("list", roleService.getRoles());
		return "roles";
	}
}
