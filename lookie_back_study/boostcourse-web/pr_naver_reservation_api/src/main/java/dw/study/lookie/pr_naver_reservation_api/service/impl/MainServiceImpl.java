package dw.study.lookie.pr_naver_reservation_api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dw.study.lookie.pr_naver_reservation_api.dao.CategoryDao;
import dw.study.lookie.pr_naver_reservation_api.dao.ProductDao;
import dw.study.lookie.pr_naver_reservation_api.dao.PromotionDao;
import dw.study.lookie.pr_naver_reservation_api.dto.CategoryDto;
import dw.study.lookie.pr_naver_reservation_api.dto.ProductDto;
import dw.study.lookie.pr_naver_reservation_api.dto.PromotionDto;
import dw.study.lookie.pr_naver_reservation_api.service.MainService;

@Service
public class MainServiceImpl implements MainService {

	@Autowired
	CategoryDao categoryDao;
	@Autowired
	ProductDao productDao;
	@Autowired
	PromotionDao promotionDao;

	@Override
	public int getCountCategory() {
		return categoryDao.selectCount();
	}

	@Override
	public int getCountDisplayInfo(Integer categoryId) {
		if (categoryId == 0)
			return productDao.countAllDisplayInfo(categoryId);
		else
			return productDao.countDisplayInfoByCategory(categoryId);
	}

	@Override
	public int getCountPromotion() {
		return promotionDao.selectCount();
	}

	@Override
	@Transactional
	public List<CategoryDto> getCategoryList() {
		return categoryDao.selectAll();
	}

	@Override
	@Transactional
	public List<ProductDto> getDisplayInfos(Integer categoryId, Integer start) {
		if (categoryId == 0)
			return productDao.selectAllDisplayInfos(start, LIMIT);
		else
			return productDao.selectDisplayInfosByCategory(categoryId, start, LIMIT);
	}

	@Override
	@Transactional
	public List<PromotionDto> getPromotionList() {
		return promotionDao.selectAll();
	}

}
