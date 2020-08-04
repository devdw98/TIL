package dw.study.lookie.pr_naver_reservation_api.dao;

public class ReservationInfoPriceDaoSqls {

	public static final String SELECT_ALL_BY_RESERVATION_INFO_ID = "SELECT * FROM reservation_info_price WHERE reservation_info_id = :reservationInfoId";
	public static final String INSERT_RESERVATION_INFO_PRICE = "INSERT INTO reservation_info_price ("
			+ "reservation_info_id, product_price_id, count) VALUES (" + ":reservationInfoId, :productPriceId, :count)";
	public static final String GET_SUM_PRICE = "SELECT sum(p.price * r.count) as sum "
			+ "FROM reservation_info_price r INNER JOIN product_price p ON r.product_price_id = p.id WHERE reservation_info_id = :reservationInfoId";
}
