package dw.study.lookie.w5_securityexam.controller;

import java.lang.reflect.Member;
import java.security.Principal;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dw.study.lookie.w5_securityexam.service.MemberService;

@Controller
@RequestMapping(path = "/members")
public class MemberController {
	// 스프링 컨테이너가 생성자를 통해 자동 주입함
	private final MemberService memberService;
	private final PasswordEncoder passwordEncoder;

	public MemberController(MemberService memberService, PasswordEncoder passwordEncoder) {
		this.memberService = memberService;
		this.passwordEncoder = passwordEncoder;
	}

	@GetMapping("/loginform")
	public String loginform() {
		return "members/loginform";
	}

	@RequestMapping("loginerror")
	public String loginerror(@RequestParam("login_error") String loginError) {
		return "members/loginerror";
	}

	@GetMapping("/memberinfo")
	public String memberInfo(Principal principal, ModelMap modelMap) {
		String loginId = principal.getName();
		Member member = memberService.getMemberByEmail(loginId);
		modelMap.addAttribute("member", member);

		return "members/memberinfo";
	}

}
