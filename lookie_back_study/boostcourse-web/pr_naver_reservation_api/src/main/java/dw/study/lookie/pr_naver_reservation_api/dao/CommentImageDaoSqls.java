package dw.study.lookie.pr_naver_reservation_api.dao;

public class CommentImageDaoSqls {
	public static final String SELECT_ALL = "SELECT i.id id, reservation_info_id, reservation_user_comment_id, file_id, file_name, save_file_name, content_type, delete_flag, create_date, modify_date "
			+ " FROM reservation_user_comment_image i, file_info f WHERE i.file_id = f.id AND i.id = :commentId";
}
