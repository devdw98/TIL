package dw.study.lookie.pr_naver_reservation_api.dao;

public class ReservationInfoDaoSqls {
	public static final String SELECT_ALL_BY_RESERVATION_INFO = "SELECT r.id id, product_id, display_info_id, cancel_flag, user_id, reservation_date, r.create_date, r.modify_date, content, description "
			+ "FROM reservation_info r INNER JOIN product p ON product_id = p.id WHERE user_id = :userId";

	public static final String SELECT_RESERVATION_INFO_COUNT = "SELECT count(*) FROM reservation_info WHERE user_id = :userId";
}
