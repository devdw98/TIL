package dw.study.lookie.pr_naver_reservation_api.service;

import java.util.List;

import dw.study.lookie.pr_naver_reservation_api.dto.Product;

public interface ProductService {
	public static final Integer LIMIT = 4;
	
	public int getCount();
	public List<Product> getProductInfos(Integer categoryId, Integer start);
}
