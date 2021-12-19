package dw.study.lookie.pr_naver_reservation_api.dao;

public class DisplayInfoImageDaoSqls {
	public static final String SELECT_ALL_BY_DISPLAY = "SELECT d.id id, display_info_id, file_id fileInfoId, file_name, save_file_name, content_type, delete_flag, create_date, modify_date "
			+ "FROM display_info_image d INNER JOIN file_info f ON d.file_id = f.id WHERE display_info_id = :displayInfoId";

}
