package dw.study.lookie.pr_naver_reservation_api.dao;

public class PromotionDaoSqls {
	public static final String SELECT_COUNT = "SELECT count(*) FROM promotion";
	public static final String SELECT_ALL = "SELECT p.id id, p.productId productId, p.categoryId categoryId, p.name categoryName, p.description description, product_image.file_id fileId "
			+ "FROM ("
			+ "SELECT p.id id, p.productId productId, p.categoryId categoryId, p.description description, c.name name "
			+ "FROM ("
			+ "SELECT promotion.id id, product.id productId, product.category_id categoryId, product.description description "
			+ "FROM promotion INNER JOIN product ON promotion.product_id = product.id"
			+ ") p INNER JOIN category c ON p.categoryId = c.id"
			+ ") p INNER JOIN product_image ON p.productId = product_image.product_id "
			+ "WHERE product_image.type = 'th'";
}
