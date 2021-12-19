package dw.study.lookie.w3_guestbook.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dw.study.lookie.w3_guestbook.dto.Guestbook;
import dw.study.lookie.w3_guestbook.service.GuestbookService;

@Controller // component scan 시 잘 찾을 수 있음
public class GuestbookController {
	@Autowired
	GuestbookService gbService;

	@GetMapping("/list")
	public String list(@RequestParam(name = "start", required = false, defaultValue = "0") int start, ModelMap model,
			 HttpServletRequest request,// 쿠키 실습
//			@CookieValue(value = "count", defaultValue = "0", required = true) String value,
			HttpServletResponse response) {

		// Spring MVC 사용 안할 때 코드
		String value = null; // 쿠키는 string 값을 갖는다
		boolean find = false;
		Cookie[] cookies = request.getCookies(); // 쿠키를 가지고 있는지 확인
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("count".equals(cookie.getName())) {
					find = true;
					value = cookie.getValue();
					break;
				}
			}
		}

		if (!find) {
			value = "1";
		} else {
		try {
			int i = Integer.parseInt(value);
			value = Integer.toString(i++);
		} catch (Exception e) {
			value = "1";
		}
		}

		Cookie cookie = new Cookie("count", value); // 새로운 값을 가진 쿠키 만들기(항상 해줘야 함)
		cookie.setMaxAge(60 * 60 * 24 * 365); // 1년동안 쿠키 유지
		cookie.setPath("/"); // 해당 경로 이하에 모두 쿠키 허용
		response.addCookie(cookie);

		// start로 시작하는 방명록 목록 구하기
		List<Guestbook> list = gbService.getGuestbooks(start);

		// 전체 페이지 수 구하기
		int count = gbService.getCount();
		int pageCount = count / GuestbookService.LIMIT;
		if (count % GuestbookService.LIMIT > 0) {
			pageCount++;
		}

		// page 수만큼 start의 값을 리스트로 저장
		// -> pageNum == 3 -> [0, 5, 10] 으로 저장됨
		// list?start=0, list?start=5, list?start=10 으로 링크가 걸림

		List<Integer> pageStartList = new ArrayList<>();
		for (int i = 0; i < pageCount; i++) {
			pageStartList.add(i * GuestbookService.LIMIT);
		}

		// jsp에서 사용할 수 있도록 모델에 넣어줌
		model.addAttribute("list", list);
		model.addAttribute("count", count);
		model.addAttribute("pageStartList", pageStartList);
		model.addAttribute("cookieCount", value); // 쿠키값 보내기
		return "list"; // 이곳에서 모델 사용함

	}

	@PostMapping("/write")
	public String write(@ModelAttribute Guestbook gb, HttpServletRequest req) {
		String clientIp = req.getRemoteAddr();
		System.out.println("clientIp: " + clientIp);
		gbService.addGuestbook(gb, clientIp);
		return "redirect:list";
	}
}
