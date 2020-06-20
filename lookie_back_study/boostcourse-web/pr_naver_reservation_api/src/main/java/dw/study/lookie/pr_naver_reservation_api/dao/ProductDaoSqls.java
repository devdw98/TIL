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

	public static final String SELECT_PRODUCT_IMAGE = "SELECT product_id, p.id, type, file_id fileInfoId, file_name, save_file_name, content_type, delete_flag, create_date, modify_date "
			+ "FROM product_image p INNER JOIN file_info f ON p.file_id = f.id WHERE p.product_id = "
			+ "(SELECT product.id FROM product, display_info WHERE product.id = display_info.product_id AND display_info.id = :displayId) AND type = 'ma'";

	public static final String SELECT_DISPLAYINFO_IMAGE = "SELECT d.id, display_info_id, file_id fileInfoId, file_name, save_file_name, content_type, delete_flag, create_date, modify_date "
			+ "FROM display_info_image d INNER JOIN file_info f ON d.file_id = f.id WHERE display_info_id = :displayId";

	public static final String SELECT_PRODUCT_PRICE = "SELECT * from "
			+ "(SELECT product.id id FROM product, display_info WHERE product.id = display_info.product_id AND display_info.id = :displayId) p,"
			+ "product_price WHERE p.id = product_price.product_id ORDER BY product_price.id DESC";

	public static final String SELECT_PRODUCT_SCORE = "SELECT score FROM reservation_user_comment r "
			+ "WHERE r.product_id = (SELECT product_id FROM product INNER JOIN display_info ON product.id = display_info.product_id WHERE display_info.id = :displayId)";

	public static final String SELECT_COUNT_PRODUCT_COMMENT = "SELECT count(*) FROM reservation_user_comment r WHERE r.product_id = :productId";

	public static final String SELECT_PRODUCT_RESERVATION_USER_COMMENTS = "SELECT r.id, product_id, reservation_info_id, score, email reservationEmail, comment, r.create_date, r.modify_date "
			+ "FROM reservation_user_comment r, user u WHERE r.user_id = u.id AND product_id = :productId ORDER BY id DESC LIMIT :start, :end";

	public static final String SELECT_PRODUCT_RESERVATION_USER_COMMENTS_IMAGE = "SELECT file_id fileInfoId, reservation_info_id, reservation_user_comment_id, file_name, save_file_name, content_type, delete_flag, create_date, modify_date"
			+ " FROM (SELECT file_id, i.reservation_info_id, i.reservation_user_comment_id FROM reservation_user_comment r INNER JOIN reservation_user_comment_image i ON r.id = i.reservation_user_comment_id WHERE i.reservation_user_comment_id = :commentId) r "
			+ " INNER JOIN file_info f ON r.file_id = f.id";
}
