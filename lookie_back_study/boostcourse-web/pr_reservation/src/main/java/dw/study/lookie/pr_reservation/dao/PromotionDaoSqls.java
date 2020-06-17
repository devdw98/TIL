package dw.study.lookie.pr_reservation.dao;

public class PromotionDaoSqls {
	//select result.id, productId, save_file_name from (select pro.id id, pro.productId productId, file_id  from product_image inner join (
		//	select promotion.id id, product.id productId from product inner join promotion on product.id = promotion.product_id) pro 
		//on pro.id = product_image.product_id where type = 'th') result, file_info where result.file_id = file_info.id;
		public static final String SELECT_ALL = "SELECT result.id, productId, save_file_name productImageUrl FROM ("
				+ "SELECT pro.id id, pro.productId productId, file_id FROM product_image INNER JOIN ( "
				+ "SELECT promotion.id id, product.id productId FROM product INNER JOIN promotion ON product.id = promotion.product_id"
				+ ") pro ON pro.id = product_image.product_id WHERE type = 'th'"
				+ ") result, file_info WHERE result.file_id = file_info.id";

		public static final String SELECT_COUNT = "SELECT count(*) FROM ";
}
