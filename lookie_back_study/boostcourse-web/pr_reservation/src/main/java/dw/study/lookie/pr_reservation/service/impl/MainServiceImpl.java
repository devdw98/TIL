package dw.study.lookie.pr_reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dw.study.lookie.pr_reservation.dao.CategoryDao;
import dw.study.lookie.pr_reservation.dao.ProductDao;
import dw.study.lookie.pr_reservation.dao.PromotionDao;
import dw.study.lookie.pr_reservation.dto.Category;
import dw.study.lookie.pr_reservation.dto.Product;
import dw.study.lookie.pr_reservation.dto.Promotion;
import dw.study.lookie.pr_reservation.service.MainService;

@Service
public class MainServiceImpl implements MainService{

	@Autowired
	CategoryDao cDao;
	
	@Autowired
	ProductDao pDao;
	
	@Autowired
	PromotionDao promotionDao;

	@Override
	@Transactional
	public List<Category> getCategoryList() {
		List<Category> list = cDao.selectCategory();
		return list;
	}

	@Override
	public List<Product> getAllProductList() {
		List<Product> list = pDao.selectAllProduct();
		return list;
	}

	@Override
	public List<Product> getProductList(Integer categoryId) {
		List<Product> list = pDao.selectProductsFromCategory(categoryId);
		return list;
	}

	@Override
	public List<Promotion> getPromotionList() {
		List<Promotion> list = promotionDao.selectPromotion();
		return list;
	}

	@Override
	public int getAllProductCount() {
		int count = pDao.countAllProducts();
		return count;
	}

//	@Override
//	public int getCategoryProductCount(int categoryId) {
//		int count = pDao.countProductInCategory(categoryId);
//		return count;
//	}


}
