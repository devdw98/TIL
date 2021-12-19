package dw.study.lookie.pr_naver_reservation_api.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dw.study.lookie.pr_naver_reservation_api.config.ApplicationConfig;
import dw.study.lookie.pr_naver_reservation_api.dto.CategoryDto;

public class DaoTests {
	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		CategoryDao cDao = ac.getBean(CategoryDao.class);
		List<CategoryDto> categoryList = new ArrayList<CategoryDto>();
		categoryList = cDao.selectAll();
		for(CategoryDto c : categoryList) {
			System.out.println(c);
		}
		int count = cDao.selectCount();
		System.out.println(count);
	}
}
