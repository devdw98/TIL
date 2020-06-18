package dw.study.lookie.pr_naver_reservation_api.service;

import java.util.List;

import dw.study.lookie.pr_naver_reservation_api.dto.Category;
import dw.study.lookie.pr_naver_reservation_api.dto.Product;
import dw.study.lookie.pr_naver_reservation_api.dto.Promotion;

public interface MainService {
	public static final Integer LIMIT = 4;

	public int getCountCategory(); // 전체 카테고리 수

	public int getCountProduct(Integer categoryId); // 상품 개수

	public int getCountPromotion(); // 전체 프로모션 개수

	public List<Category> getCategoryList(); // 카테고리 목록

	public List<Product> getProductInfos(Integer categoryId, Integer start); //상품 목록

	public List<Promotion> getPromotionList(); // 프로모션 목록
}
