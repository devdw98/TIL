package dw.study.lookie.pr_naver_reservation_api.dao;

public class PromotionDaoSqls {
	public static final String SELECT_COUNT = "SELECT count(*) FROM promotion";
	public static final String SELECT_ALL = 
			"select p.id id, p.productId productId, p.categoryId categoryId, p.name categoryName, p.description description, product_image.file_id fileId " 
			+ "from ("
			+ "select p.id id, p.productId productId, p.categoryId categoryId,	p.description description, c.name name " 
			+ "from ("
			+ "select promotion.id id, product.id productId, product.category_id categoryId, product.description description "
			+ "from promotion inner join product on promotion.product_id = product.id"
			+ ") p inner join category c on p.categoryId = c.id" 
			+ ") p inner join product_image on p.productId = product_image.product_id "
			+ "where product_image.type = 'th'";
}
