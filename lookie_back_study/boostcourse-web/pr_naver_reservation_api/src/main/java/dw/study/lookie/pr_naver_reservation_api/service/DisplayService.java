package dw.study.lookie.pr_naver_reservation_api.service;

import java.util.List;

import dw.study.lookie.pr_naver_reservation_api.dto.DisplayInfoImage;
import dw.study.lookie.pr_naver_reservation_api.dto.Product;
import dw.study.lookie.pr_naver_reservation_api.dto.ProductImage;
import dw.study.lookie.pr_naver_reservation_api.dto.ProductPrice;

public interface DisplayService {
	public Product getProductInfo(Integer displayId);
	public List<ProductImage> getProductImageInfoList(Integer displayId);
	public List<DisplayInfoImage> getDisplayInfoImageList(Integer displayId);
	public List<ProductPrice> getProductPriceList(Integer displayId);
	public int getAvgScore(Integer displayId);
}
