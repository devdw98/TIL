package dw.study.lookie.pr_naver_reservation_api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dw.study.lookie.pr_naver_reservation_api.dao.CategoryDao;
import dw.study.lookie.pr_naver_reservation_api.dto.Category;
import dw.study.lookie.pr_naver_reservation_api.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDao cDao;
	
	@Override
	public int getCount() {
		return cDao.selectCount();
	}

	@Override
	@Transactional //내부적으로 readOnly 형태로 connection 사용
	public List<Category> getCategoryList() {
		return cDao.selectAll();
	}

}
