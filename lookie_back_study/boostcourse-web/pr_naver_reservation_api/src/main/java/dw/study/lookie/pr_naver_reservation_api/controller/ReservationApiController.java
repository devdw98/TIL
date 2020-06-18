package dw.study.lookie.pr_naver_reservation_api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dw.study.lookie.pr_naver_reservation_api.dto.Category;
import dw.study.lookie.pr_naver_reservation_api.dto.Promotion;
import dw.study.lookie.pr_naver_reservation_api.service.CategoryService;
import dw.study.lookie.pr_naver_reservation_api.service.PromotionService;

@RestController
@RequestMapping(path = "/api")
public class ReservationApiController {

	@Autowired
	private CategoryService categoryService;
	@Autowired
	private PromotionService promotionService;

	// Main Page
	@GetMapping("/categories") // 카테고리 목록
	public Map<String, Object> categoryList() {

		List<Category> list = categoryService.getCategoryList();
		int size = categoryService.getCount();

		Map<String, Object> map = new HashMap<>();
		map.put("size", size);
		map.put("items", list);
		return map;
	}
	
	@GetMapping("/displayinfos") //상품 목록
	public String productList(@RequestParam("categoryId")int categoryId, @RequestParam("start")int start) {
		return "상품목록";
	}
	
	@GetMapping("/promotions") //프로모션 목록
	public Map<String, Object> promotionList() {
		List<Promotion> list = promotionService.getPromotionList();
		int size = promotionService.getCount();
		
		Map<String, Object> map = new HashMap<>();
		map.put("size", size);
		map.put("items", list);
		return map;
	}
	
//	//ProductPage
//	@GetMapping("/displayinfos/{id}") //전시 정보
//	public String productInfo() {
//		return null;
//	}
//	
//	@GetMapping("/displayinfos") //상품의 댓글 목록
//	public String productCommentList() {
//		return null;
//	}

}
