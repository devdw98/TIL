package dw.study.lookie.pr_naver_reservation_api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dw.study.lookie.pr_naver_reservation_api.dao.ProductDao;
import dw.study.lookie.pr_naver_reservation_api.dto.DisplayInfoImage;
import dw.study.lookie.pr_naver_reservation_api.dto.Product;
import dw.study.lookie.pr_naver_reservation_api.dto.ProductImage;
import dw.study.lookie.pr_naver_reservation_api.dto.ProductPrice;
import dw.study.lookie.pr_naver_reservation_api.dto.ReservationUserComment;
import dw.study.lookie.pr_naver_reservation_api.dto.ReservationUserCommentImage;
import dw.study.lookie.pr_naver_reservation_api.service.DisplayService;

@Service
public class DisplayServiceImpl implements DisplayService {
	@Autowired
	ProductDao productDao;

	@Override
	public Product getProductInfo(Integer displayId) {
		return productDao.selectProductInfo(displayId);
	}

	@Override
	public List<ProductImage> getProductImageInfoList(Integer displayId) {
		return productDao.selectProductImageInfo(displayId);

	}

	@Override

	public List<DisplayInfoImage> getDisplayInfoImageList(Integer displayId) {
		return (List<DisplayInfoImage>) productDao.selectDisplayInfoImageInfo(displayId);
	}

	@Override
	public List<ProductPrice> getProductPriceList(Integer displayId) {
		return productDao.selectProductPriceInfo(displayId);
	}

	@Override
	public int getAvgScore(Integer displayId) {
		List<Integer> scoreList = productDao.selectDisplayInfoScore(displayId);
		int result = 0;
		if(scoreList.size() == 0) {
			
		}else {
			for(int i : scoreList) {
				result += i;
			}
			result = (int)result / scoreList.size();
		}
		
		return result;
	}

	@Override
	public int getCountProductReservationUserComment(Integer productId) {

		return productDao.selectCountProductComments(productId);
	}

	@Override
	public List<ReservationUserComment> getProductReservationUserCommentList(Integer productId, Integer start) {
		List<ReservationUserComment> list = productDao.selectProductComments(productId, start, LIMIT);
		for(ReservationUserComment i : list) {
			List<ReservationUserCommentImage> imageList = productDao.selectProductCommentImages(i.getId());
			i.setReservationUserCommentImages(imageList);
		}
		return list;
	}

}
