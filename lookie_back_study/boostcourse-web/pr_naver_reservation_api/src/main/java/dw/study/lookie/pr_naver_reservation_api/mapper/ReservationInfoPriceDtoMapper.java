package dw.study.lookie.pr_naver_reservation_api.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dw.study.lookie.pr_naver_reservation_api.dto.ReservationInfoPriceDto;
import dw.study.lookie.pr_naver_reservation_api.vo.ReservationInfoPrice;

public class ReservationInfoPriceDtoMapper implements RowMapper<ReservationInfoPrice>{

	@Override
	public ReservationInfoPrice mapRow(ResultSet rs, int rowNum) throws SQLException {
		ReservationInfoPriceDto dto = new ReservationInfoPriceDto();
		ReservationInfoPrice price = new ReservationInfoPrice();
		price.setId(rs.getInt("id"));
		price.setCount(rs.getInt("count"));
		price.setProductPriceId(rs.getInt("product_price_id"));
		price.setReservationInfoId(rs.getInt("reservation_info_id"));
		
//		dto.setPrice(price);
//		return dto;
		return price;
	}

	
}
