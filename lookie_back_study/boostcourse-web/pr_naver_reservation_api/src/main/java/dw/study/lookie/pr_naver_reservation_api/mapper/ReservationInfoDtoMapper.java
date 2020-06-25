package dw.study.lookie.pr_naver_reservation_api.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dw.study.lookie.pr_naver_reservation_api.dto.ReservationInfoDto;
import dw.study.lookie.pr_naver_reservation_api.vo.DateInfo;
import dw.study.lookie.pr_naver_reservation_api.vo.ReservationInfo;

public class ReservationInfoDtoMapper implements RowMapper<ReservationInfoDto>{

	@Override
	public ReservationInfoDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		ReservationInfoDto dto = new ReservationInfoDto();
		ReservationInfo info = new ReservationInfo();
		DateInfo date = new DateInfo();
		info.setId(rs.getInt("id"));
		info.setProductId(rs.getInt("product_id"));
		info.setDisplayInfoId(rs.getInt("display_info_id"));
		info.setCancelFlag(rs.getInt("cancel_flag"));
		info.setUserId(rs.getInt("user_id"));
		info.setReservationDate(rs.getDate("reservation_date"));
		date.setCreateDate(rs.getDate("create_date"));
		date.setModifyDate(rs.getDate("modify_date"));
		info.setDateInfo(date);
		dto.setReservationInfo(info);
		dto.setContent(rs.getString("content"));
		dto.setDescription(rs.getString("description"));
		
		return dto;
	}
	

}
