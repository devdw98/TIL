package dw.study.lookie.pr_naver_reservation_api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dw.study.lookie.pr_naver_reservation_api.service.UserService;

@Controller
@RequestMapping(path="/users")
public class UserController {
	
	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/loginform")
	public String loginform() {
		return "/user/loginform";
	}
	
	@RequestMapping("/loginerror")
	public String loginerror(@RequestParam("login_error") String loginError) {
		return "/user/loginerror";
	}
	
}
