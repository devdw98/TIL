package dw.study.lookie.pr_reservation.service;

import java.util.List;

import dw.study.lookie.pr_reservation.dto.Category;
import dw.study.lookie.pr_reservation.dto.Product;
import dw.study.lookie.pr_reservation.dto.Promotion;

public interface MainService {
	
	public List<Category> getCategoryList(); //카테고리 목록과 카테고리 안의 상품 개수
	
	public List<Product> getAllProductList(); // 총 상품 목록
	public List<Product> getProductList(Integer categoryId); //카테고리 별 상품 목록
	public List<Promotion> getPromotionList(); //프로모션 상품 목록
	
	public int getAllProductCount(); // 총 상품 개수 
//	public int getCategoryProductCount(int categoryId); //각 카테고리 별 상품 개수

}
