package dw.study.lookie.pr_naver_reservation_api.service;

import java.util.List;

import dw.study.lookie.pr_naver_reservation_api.dto.Category;

public interface CategoryService {
	public int getCount();
	public List<Category> getCategoryList();
}
