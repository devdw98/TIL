package dw.study.lookie.pr_naver_reservation_api.dao;

public class CommentDaoSqls {
	public static final String COUNT_BY_PRODUCT = "SELECT count(*) FROM reservation_user_comment r WHERE r.product_id = :productId";
	public static final String SELECT_ALL_BY_PRODUCT = "SELECT * FROM reservation_user_comment WHERE product_id = :productId";
	public static final String SELECT_COMMENTID_LIST = "SELECT id FROM reservation_user_comment WHERE product_id = :productId";
	public static final String SELECT_COMMENT_BY_COMMENT_ID = "SELECT * FROM reservation_user_comment WHERE id = :commentId";
}
