package dw.study.lookie.w3_mvcexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlusController {
//실제 두 값을 받아서 결과를 처리하는 곳

	@GetMapping(path = "/plusform")
	public String plusform() { // 요청이 들어왔을 때 특정 뷰를 보여주세요!
		return "plusForm";
	}

	@PostMapping(path = "/plus")
	public String plus(@RequestParam(name = "value", required = true) int value1,
			@RequestParam(name = "value2", required = true) int value2, ModelMap modelMap) {
		int result = value1 + value2;

		modelMap.addAttribute("value", value1);
		modelMap.addAttribute("value2", value2);
		modelMap.addAttribute("result", result);
		return "plusResult";
	}

}
