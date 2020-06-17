package dw.study.lookie.w3_guestbook.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dw.study.lookie.w3_guestbook.dto.Guestbook;
import dw.study.lookie.w3_guestbook.service.GuestbookService;

@RestController //RestController 라고 선언
@RequestMapping(path="/guestbooks") //URI 공통 사용
public class GuestbookApiController {
	@Autowired
	GuestbookService gbService;
	
	@GetMapping //path 따로 지정 안하고, GET 요청으로 /guestbooks 면 실행됨
	public Map<String, Object> list(@RequestParam(name="start", required = false, defaultValue="0") int start){
		//application/json 요청이기 때문에 
		//DispatcherServlet은 jsonMessageConvert를 내부적으로 사용하여
		//해당 Map 객체를 json으로 변환하여 전송하게 됨
		List<Guestbook> list = gbService.getGuestbooks(start);
		
		int count = gbService.getCount();
		int pageCount = count / GuestbookService.LIMIT;
		if (count % GuestbookService.LIMIT > 0) {
			pageCount++; 
		}
		
		List<Integer> pageStartList = new ArrayList<>();
		for (int i = 0; i < pageCount; i++) {
			pageStartList.add(i * GuestbookService.LIMIT);
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("count", count);
		map.put("pageStartList", pageStartList);
		
		return map;
	}
	
	@PostMapping
	public Guestbook write(@RequestBody Guestbook gb, HttpServletRequest req) {
		String clientIp = req.getRemoteAddr();
		//id 가 입력된 guestbook이 반환된다.
		Guestbook result = gbService.addGuestbook(gb, clientIp);
		return result;
	}
	
	@DeleteMapping("/{id}")
	public Map<String, String> delete(@PathVariable(name="id") Long id, HttpServletRequest req){
		//@PathVariable : 값을 읽어들임
		String clientIp = req.getRemoteAddr();
		int deleteCount = gbService.deleteGuestbook(id, clientIp);
		return Collections.singletonMap("success", deleteCount > 0 ? "true":"false");
	}
	
}
