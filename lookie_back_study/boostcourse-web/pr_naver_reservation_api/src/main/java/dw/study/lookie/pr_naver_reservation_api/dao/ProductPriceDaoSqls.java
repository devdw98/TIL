package dw.study.lookie.pr_naver_reservation_api.dao;

public class ProductPriceDaoSqls {
	public static final String SELECT_ALL_BY_PRICE = "SELECT * FROM product_price p WHERE p.product_id = :productId ORDER BY p.id DESC";
}
