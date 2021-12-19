package dw.study.lookie.pr_reservation.dao;

public class CategoryDaoSqls {

	public static final String SELECT_ALL = "SELECT category.id, category.name, count(product.id) Count FROM category, product WHERE category.id = product.category_id GROUP BY category.id";

}
