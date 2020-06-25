package dw.study.lookie.pr_naver_reservation_api.dao;

public class ProductDaoSqls {
	public static final String GET_PRODUCT_ID = "SELECT product_id FROM display_info WHERE id = :displayInfoId";
	public static final String SELECT_ALL = "SELECT p.id id, categoryId, display_info.id displayInfoId, name, description, content,"
			+ "			event, opening_hours, place_name, place_lot, place_street, tel, homepage, email, create_date, modify_date, fileId "
			+ "			FROM (SELECT p.id id, categoryId, name, description, content, event, i.file_id fileId "
			+ "			FROM (SELECT p.id id, c.id categoryId, name, description, content, event "
			+ "			FROM category c INNER JOIN product p ON c.id = p.category_id "
			+ "			) p, product_image i WHERE i.type = 'ma' AND p.id = i.product_id"
			+ "			) p, display_info WHERE display_info.product_id = p.id limit :start, :end";
	public static final String SELECT_ALL_COUNT = "SELECT count(*) FROM display_info";
	public static final String SELECT_BY_CATEGORY = "SELECT p.id id, categoryId, display_info.id displayInfoId, name, description, content,"
			+ "			event, opening_hours, place_name, place_lot, place_street, tel, homepage, email, create_date, modify_date, fileId "
			+ "			FROM (SELECT p.id id, categoryId, name, description, content, event, i.file_id fileId "
			+ "			FROM (SELECT p.id id, c.id categoryId, name, description, content, event "
			+ "			FROM category c INNER JOIN product p ON c.id = p.category_id WHERE c.id = :categoryId "
			+ "			) p, product_image i WHERE i.type = 'ma' AND p.id = i.product_id"
			+ "			) p, display_info WHERE display_info.product_id = p.id LIMIT :start, :end";
	public static final String SELECT_COUNT_BY_CATEGORY = "SELECT count(*) FROM ("
			+ "			SELECT product.category_id cid FROM display_info, product WHERE display_info.product_id = product.id"
			+ "			) real_product, category WHERE real_product.cid = category.id AND category.id = :categoryId GROUP BY category.id";
	public static final String SELECT_DISPLAY_INFO = "SELECT p.id productId, categoryId, display_info.id displayInfoId, name, description, content, event, "
			+ "opening_hours, place_name, place_lot, place_street, tel, homepage, email, create_date, modify_date, fileId "
			+ "FROM (SELECT p.id id, categoryId, name, description, content, event, i.file_id fileId "
			+ "FROM (SELECT p.id id, c.id categoryId, name, description, content, event FROM category c INNER JOIN product p ON c.id = p.category_id) "
			+ "p, product_image i WHERE i.type = 'ma' AND p.id = i.product_id) "
			+ "p, display_info WHERE display_info.product_id = p.id AND display_info.id = :displayId";
}
