package dw.study.lookie.pr_naver_reservation_api.dao;

public class ProductDaoSqls {
	public static final String SELECT_COUNT_PRODUCTS_BY_CATEGORY = "SELECT count(*) FROM ("
			+ "SELECT product.category_id cid FROM display_info, product WHERE display_info.product_id = product.id"
			+ ") real_product, category WHERE real_product.cid = category.id AND category.id = :categoryId GROUP BY category.id";

	public static final String SELECT_COUNT_ALL_PRODUCTS = "SELECT count(*) FROM ("
			+ "SELECT product.category_id cid FROM display_info, product WHERE display_info.product_id = product.id"
			+ ") real_product, category WHERE real_product.cid = category.id";

	public static final String SELECT_ALL_PRODUCTS_INFO = "SELECT p.id id, categoryId, display_info.id displayInfoId, name, description, content,"
			+ "			event, opening_hours, place_name, place_lot, place_street, tel, homepage, email, create_date, modify_date, fileId "
			+ "			FROM (SELECT p.id id, categoryId, name, description, content, event, i.file_id fileId "
			+ "			FROM (SELECT p.id id, c.id categoryId, name, description, content, event "
			+ "			FROM category c INNER JOIN product p ON c.id = p.category_id "
			+ "			) p, product_image i WHERE i.type = 'ma' AND p.id = i.product_id"
			+ "			) p, display_info WHERE display_info.product_id = p.id limit :start, :end";

	public static final String SELECT_PRODUCTS_INFO = "SELECT p.id id, categoryId, display_info.id displayInfoId, name, description, content,"
			+ "			event, opening_hours, place_name, place_lot, place_street, tel, homepage, email, create_date, modify_date, fileId "
			+ "			FROM (SELECT p.id id, categoryId, name, description, content, event, i.file_id fileId "
			+ "			FROM (SELECT p.id id, c.id categoryId, name, description, content, event "
			+ "			FROM category c INNER JOIN product p ON c.id = p.category_id WHERE c.id = :categoryId "
			+ "			) p, product_image i WHERE i.type = 'ma' AND p.id = i.product_id"
			+ "			) p, display_info WHERE display_info.product_id = p.id limit :start, :end";

	public static final String SELECT_PRODUCT_INFO = "SELECT p.id id, categoryId, display_info.id displayInfoId, name, description, content, event, "
			+ "opening_hours, place_name, place_lot, place_street, tel, homepage, email, create_date, modify_date, fileId "
			+ "FROM (SELECT p.id id, categoryId, name, description, content, event, i.file_id fileId "
			+ "FROM (SELECT p.id id, c.id categoryId, name, description, content, event FROM category c INNER JOIN product p ON c.id = p.category_id) "
			+ "p, product_image i WHERE i.type = 'ma' AND p.id = i.product_id) "
			+ "p, display_info WHERE display_info.product_id = p.id AND display_info.id = :displayId";

	public static final String SELECT_PRODUCT_IMAGE = "SELECT product_id, p.id, type, file_id, file_name, save_file_name, content_type, delete_flag, create_date, modify_date "
			+ "FROM product_image p INNER JOIN file_info f ON p.file_id = f.id WHERE p.product_id = "
			+ "(SELECT product.id FROM product, display_info WHERE product.id = display_info.product_id AND display_info.id = :displayId) AND type = 'ma'";

	public static final String SELECT_DISPLAYINFO_IMAGE = "SELECT d.id, display_info_id, file_id, file_name, save_file_name, content_type, delete_flag, create_date, modify_date "
			+ "FROM display_info_image d INNER JOIN file_info f ON d.file_id = f.id WHERE display_info_id = :displayId";

	public static final String SELECT_PRODUCT_PRICE = "SELECT * from "
			+ "(SELECT product.id id FROM product, display_info WHERE product.id = display_info.product_id AND display_info.id = :displayId) p,"
			+ "product_price WHERE p.id = product_price.product_id";
}
