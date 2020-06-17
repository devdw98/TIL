package dw.study.lookie.pr_reservation.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dw.study.lookie.pr_reservation.config.ApplicationConfig;
import dw.study.lookie.pr_reservation.dto.Category;
import dw.study.lookie.pr_reservation.dto.Product;

public class DaoTests {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
//		CategoryDao cDao = ac.getBean(CategoryDao.class);
//		List<Category> categoryList = new ArrayList<Category>();
//		categoryList = cDao.selectCategory();
//		for(Category c : categoryList) {
//			System.out.println(c);
//		}
		
//		PromotionDao pDao = ac.getBean(PromotionDao.class);
//		List<Promotion> promotionList = new ArrayList<Promotion>();
//		promotionList = pDao.selectPromotion();
//		for(Promotion p : promotionList) {
//			System.out.println(p);
//		}
		
//		ProductDao pDao = ac.getBean(ProductDao.class);
//		List<Product> productList = new ArrayList<Product>();
//		productList = pDao.selectProductsFromCategory(1);
//		for(Product p : productList) {
//			System.out.println(p);
//		}
	
	}

}
