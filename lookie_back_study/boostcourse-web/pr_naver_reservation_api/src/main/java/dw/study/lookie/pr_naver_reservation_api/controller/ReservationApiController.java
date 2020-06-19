package dw.study.lookie.pr_naver_reservation_api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dw.study.lookie.pr_naver_reservation_api.dto.Category;
import dw.study.lookie.pr_naver_reservation_api.dto.DisplayInfoImage;
import dw.study.lookie.pr_naver_reservation_api.dto.Product;
import dw.study.lookie.pr_naver_reservation_api.dto.ProductImage;
import dw.study.lookie.pr_naver_reservation_api.dto.ProductPrice;
import dw.study.lookie.pr_naver_reservation_api.dto.Promotion;
import dw.study.lookie.pr_naver_reservation_api.service.DisplayService;
import dw.study.lookie.pr_naver_reservation_api.service.MainService;

@RestController
@RequestMapping(path = "/api")
public class ReservationApiController {

	@Autowired
	private MainService mainService;
	@Autowired
	private DisplayService displayService;

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
		int productCount = MainService.LIMIT; // 여기 추가로 해야함
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

	// ProductPage
//	@GetMapping("/displayinfos/{id}") // 전시 정보
//	public Map<String, Object> productInfo(@PathVariable(name="id") int id ) {
//		
//		Product information = displayService.getProductInfo(id);
//		List<Image> productImages = displayService.getProductImageInfoList(id);
//		List<Image> displayInfoImages = displayService.getDisplayInfoImageList(id);
//		int avgScore = displayService.getAvgScore(id);
//		List<ProductPrice> productPrices = displayService.getProductPriceList(id);
//		Map<String, Object> map = new HashMap<>();
//		map.put("product",information);
//		map.put("productImages", productImages);
//		map.put("displayInfoImages", displayInfoImages);
//		map.put("avgScore", avgScore);
//		map.put("productPrices",productPrices);
//		return map;
//	}
	
	@GetMapping("/displayinfos/{displayId}") //전시정보
	public Map<String, Object> productInfo(@PathVariable(name="displayId") int displayId ){
		Product productInfo = displayService.getProductInfo(displayId);
		List<ProductImage> productImages = displayService.getProductImageInfoList(displayId);
		List<DisplayInfoImage> displayInfoImages = displayService.getDisplayInfoImageList(displayId);
		List<ProductPrice> productPrices = displayService.getProductPriceList(displayId);
		
		Map<String, Object> map = new HashMap<>();
		map.put("product", productInfo);
		map.put("productImages", productImages);
		map.put("displayInfoImages", displayInfoImages);
		map.put("productPrices", productPrices);
		return map;
	}

//	public Map<String, Object> productCommentList() //상품의 댓글 목록


}
