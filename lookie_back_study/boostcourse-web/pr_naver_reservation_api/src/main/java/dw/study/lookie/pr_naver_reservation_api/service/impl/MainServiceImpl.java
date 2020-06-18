package dw.study.lookie.pr_naver_reservation_api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dw.study.lookie.pr_naver_reservation_api.dao.CategoryDao;
import dw.study.lookie.pr_naver_reservation_api.dao.ProductDao;
import dw.study.lookie.pr_naver_reservation_api.dao.PromotionDao;
import dw.study.lookie.pr_naver_reservation_api.dto.Category;
import dw.study.lookie.pr_naver_reservation_api.dto.Product;
import dw.study.lookie.pr_naver_reservation_api.dto.Promotion;
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
	public int getCountProduct(Integer categoryId) {
		int count;
		if(categoryId == 0)
			count = productDao.selecAllProductsCount();
		else
			count = productDao.selectCountProductByCategory(categoryId);
		return count;
	}

	@Override
	public int getCountPromotion() {
		return promotionDao.selectCount();
	}

	@Override
	@Transactional
	public List<Category> getCategoryList() {
		return categoryDao.selectAll();
	}

	@Override
	@Transactional
	public List<Product> getProductInfos(Integer categoryId, Integer start) {
		List<Product> list;
		if(categoryId == 0)
			list = productDao.selectAllProductsInfo(start, LIMIT);
		else
			list = productDao.selectProductsInfoByCategory(categoryId, start, LIMIT);
		return list;
	}

	@Override
	@Transactional
	public List<Promotion> getPromotionList() {
		return promotionDao.selectAll();
	}

}
