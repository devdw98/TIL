package dw.study.lookie.pr_naver_reservation_api.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dw.study.lookie.pr_naver_reservation_api.dto.CommentImageDto;
import dw.study.lookie.pr_naver_reservation_api.vo.DateInfo;
import dw.study.lookie.pr_naver_reservation_api.vo.FileInfo;
import dw.study.lookie.pr_naver_reservation_api.vo.ReservationUserCommentImage;

public class CommentImageDtoMapper implements RowMapper<CommentImageDto> {

	@Override
	public CommentImageDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		CommentImageDto dto = new CommentImageDto();
		ReservationUserCommentImage image = new ReservationUserCommentImage();
		FileInfo file = new FileInfo();
		DateInfo date = new DateInfo();
		date.setCreateDate(rs.getDate("create_date"));
		date.setModifyDate(rs.getDate("modify_date"));
		image.setId(rs.getInt("id"));
		image.setReservationInfoId(rs.getInt("reservation_info_id"));
		image.setReservationUserCommentId(rs.getInt("reservation_user_comment_id"));
		image.setFileId(rs.getInt("file_id"));
		file.setFileName(rs.getString("file_name"));
		file.setSaveFileName(rs.getString("save_file_name"));
		file.setConentType(rs.getString("content_type"));
		file.setDeleteFlag(rs.getInt("delete_flag"));
		file.setDateInfo(date);

		dto.setImage(image);
		dto.setFile(file);
		return dto;
	}

}
