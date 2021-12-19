package dw.study.lookie.pr_reservation.dao;

public class ProductDaoSqls {
	public static final String SELECT_ALL = "SELECT display_info.id displayInfoId, display_info.place_name placeName, "
			+ "product.content productContent, product.description productDescription, product.id productId, product.save_file_name productImgUrl"
			+ " FROM link_product_thumnail_img product INNER JOIN display_info "
			+ "ON product.id = display_info.product_id";
	
	public static final String SELECT_FROM_CATEGORY = "SELECT display_info.id displayInfoId, display_info.place_name placeName, "
			+ "product.content productContent, product.description productDescription, product.id productId, product.save_file_name productImgUrl"
			+ " FROM link_product_thumnail_img product INNER JOIN display_info "
			+ "ON product.id = display_info.product_id WHERE category_id = :categoryId";

	public static final String COUNT_ALL_PRODUCTS = "SELECT count(*) count FROM product";
	
	public static final String COUNT_CATEGORY_PRODUCTS = "select count(*) count from product inner join category on category.id = product.category_id where category.id = :categoryId group by category.id";

}
