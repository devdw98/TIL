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
import dw.study.lookie.pr_naver_reservation_api.dto.Product;
import dw.study.lookie.pr_naver_reservation_api.dto.Promotion;
import dw.study.lookie.pr_naver_reservation_api.service.MainService;

@RestController
@RequestMapping(path = "/api")
public class ReservationApiController {

	@Autowired
	private MainService mainService;

	// Main Page
	@GetMapping("/categories") // 카테고리 목록
	public Map<String, Object> categoryList() {

		List<Category> list = mainService.getCategoryList();
		int size = mainService.getCountCategory();

		Map<String, Object> map = new HashMap<>();
		map.put("size", size);
		map.put("items", list);
		return map;
	}

	@GetMapping("/displayinfos") // 상품 목록
	public Map<String, Object> productList(
			@RequestParam(name = "categoryId", required = false, defaultValue = "0") int categoryId,
			@RequestParam(name = "start", required = false, defaultValue = "0") int start) {

		int totalCount = mainService.getCountProduct(categoryId);
		int productCount = MainService.LIMIT; //여기 추가로 해야함
		List<Product> list = mainService.getProductInfos(categoryId, start);

		Map<String, Object> map = new HashMap<>();
		map.put("totalCount", totalCount);
		map.put("productCount", productCount);
		map.put("products", list);
		return map;
	}

	@GetMapping("/promotions") // 프로모션 목록
	public Map<String, Object> promotionList() {

		List<Promotion> list = mainService.getPromotionList();

		int size = mainService.getCountPromotion();

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
