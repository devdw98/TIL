package dw.study.lookie.w5_securityexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dw.study.lookie.w5_securityexam.service.MemberService;

@Controller
@RequestMapping(path="/members")
public class MemberController {
	//스프링 컨테이너가 생성자를 통해 자동 주입함
	private final MemberService memberService;
	
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@GetMapping("/loginform")
	public String loginform() {
		return "members/loginform";
	}
	
	@RequestMapping("loginerror")
	public String loginerror(@RequestParam("login_error")String loginError) {
		return "members/loginerror";
	}

}
