package dw.study.lookie.pr_naver_reservation_api.dto;

import dw.study.lookie.pr_naver_reservation_api.vo.Category;

public class CategoryDto {

	private Category category;
	private int count;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
