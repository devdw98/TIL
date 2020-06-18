package dw.study.lookie.pr_naver_reservation_api.dao;

public class CategoryDaoSqls {
	public static final String SELECT_COUNT = "SELECT count(*) FROM category";
	public static final String SELECT_COUNT_PRODUCTS_BY_CATEGORY = "SELECT c.id id, c.name name, count(*) count FROM category c, product p WHERE c.id = p.category_id GROUP BY p.category_id";
}
