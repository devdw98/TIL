package dw.study.lookie.pr_naver_reservation_api.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dw.study.lookie.pr_naver_reservation_api.dto.CommentDto;
import dw.study.lookie.pr_naver_reservation_api.vo.DateInfo;
import dw.study.lookie.pr_naver_reservation_api.vo.ReservationUserComment;

public class CommentDtoMapper implements RowMapper<CommentDto> {

	@Override
	public CommentDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		CommentDto dto = new CommentDto();
		ReservationUserComment comment = new ReservationUserComment();
		DateInfo date = new DateInfo();
		date.setCreateDate(rs.getDate("create_date"));
		date.setModifyDate(rs.getDate("modify_date"));
		comment.setId(rs.getInt("id"));
		comment.setProductId(rs.getInt("product_id"));
		comment.setReservationInfoId(rs.getInt("reservation_info_id"));
		comment.setScore(rs.getInt("score"));
		comment.setUserId(rs.getInt("user_id"));
		comment.setComment(rs.getString("comment"));
		comment.setDateInfo(date);
		dto.setComment(comment);
		return dto;

	}

}
