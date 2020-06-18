package dw.study.lookie.pr_naver_reservation_api.dao;

public class CategoryDaoSqls {
	public static final String SELECT_COUNT = "SELECT count(*) FROM category";
	

	
	public static final String SELECT_CATEGORY_INFO = "SELECT category.id id, category.name name, count(*) count FROM ("
			+ "SELECT product.category_id cid FROM display_info, product WHERE display_info.product_id = product.id"
			+ ") real_product, category WHERE real_product.cid = category.id GROUP BY category.id";
}
