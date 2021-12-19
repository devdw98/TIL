package dw.study.lookie.pr_naver_reservation_api.dao;

public class ProductImageDaoSqls {
	public static final String SELECT_ALL_BY_PRODUCT = "SELECT product_id, p.id id, type, file_id fileInfoId, file_name, save_file_name, content_type, delete_flag, create_date, modify_date \r\n"
			+ "			FROM product_image p INNER JOIN file_info f ON p.file_id = f.id WHERE p.product_id = :productId";
//			"SELECT product_id, p.id id, type, file_id fileInfoId, file_name, save_file_name, content_type, delete_flag, create_date, modify_date "
//			+ "FROM product_image p INNER JOIN file_info f ON p.file_id = f.id WHERE p.product_id = "
//			+ "(SELECT product.id FROM product, display_info WHERE product.id = display_info.product_id AND display_info.id = :displayId) AND type = 'ma'";
}
