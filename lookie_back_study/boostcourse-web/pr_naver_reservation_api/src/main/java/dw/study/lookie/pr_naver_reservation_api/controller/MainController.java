package dw.study.lookie.pr_naver_reservation_api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	@RequestMapping("/main")
	@ResponseBody
	public String main() {
		return "main page";
	}
	
	@RequestMapping("/securepage")
	@ResponseBody
	public String securityPage() {
		return "secure page";
	}
}
