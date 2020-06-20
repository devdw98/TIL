package dw.study.lookie.pr_naver_reservation_api.service;

import java.util.List;

import dw.study.lookie.pr_naver_reservation_api.dto.DisplayInfoImage;
import dw.study.lookie.pr_naver_reservation_api.dto.Product;
import dw.study.lookie.pr_naver_reservation_api.dto.ProductImage;
import dw.study.lookie.pr_naver_reservation_api.dto.ProductPrice;
import dw.study.lookie.pr_naver_reservation_api.dto.ReservationUserComment;

public interface DisplayService {
	public static final Integer LIMIT = 5;
	public Product getProductInfo(Integer displayId);
	public List<ProductImage> getProductImageInfoList(Integer displayId);
	public List<DisplayInfoImage> getDisplayInfoImageList(Integer displayId);
	public List<ProductPrice> getProductPriceList(Integer displayId);
	public int getAvgScore(Integer displayId);
	public int getCountProductReservationUserComment(Integer productId);
	public List<ReservationUserComment> getProductReservationUserCommentList(Integer productId, Integer start);
}
