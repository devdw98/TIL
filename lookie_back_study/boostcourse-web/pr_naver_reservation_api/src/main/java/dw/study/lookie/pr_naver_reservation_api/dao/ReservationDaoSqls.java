package dw.study.lookie.pr_naver_reservation_api.dao;

public class ReservationDaoSqls {
	public static final String INSERT_RESERVATION_INFO = "INSERT INTO reservation_info ("
			+ "product_id, display_info_id, user_id, reservation_date, create_date, modify_date) VALUES ("
			+ ":productId, :displayInfoId, :reservationDate, :userId, :createDate, :modifyDate) ";
	
	public static final String CHANGE_CANCEL_FLAG = "UPDATE reservation_info SET cancel_flag = WHEN cancel_flag = 0 THEN 1 ELSE 1 END";

}
