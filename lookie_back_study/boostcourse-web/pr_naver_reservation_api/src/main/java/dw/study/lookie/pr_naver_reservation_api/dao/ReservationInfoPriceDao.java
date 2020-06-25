package dw.study.lookie.pr_naver_reservation_api.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import dw.study.lookie.pr_naver_reservation_api.dto.ReservationInfoPriceDto;
import dw.study.lookie.pr_naver_reservation_api.mapper.ReservationInfoPriceDtoMapper;

@Repository
public class ReservationInfoPriceDao {
	NamedParameterJdbcTemplate jdbc;
//	RowMapper<ReservationInfoPriceDto> rowMapper = BeanPropertyRowMapper.newInstance(ReservationInfoPriceDto.class);
	ReservationInfoPriceDtoMapper rowMapper = new ReservationInfoPriceDtoMapper();
	SimpleJdbcInsert insertAction;

	public ReservationInfoPriceDao(DataSource ds) {
		this.jdbc = new NamedParameterJdbcTemplate(ds);
		this.insertAction = new SimpleJdbcInsert(ds);
	}

//	public int insertReservationInfoPrices(Integer reservationInfoId, Integer productPriceId ) {
//		
//	}

	public List<ReservationInfoPriceDto> selectReservationInfoPrices(Integer reservationInfoId) {
		Map<String, Object> params = new HashMap<>();
		params.put("reservationInfoId", reservationInfoId);
		return jdbc.query(ReservationInfoPriceDaoSqls.SELECT_ALL_BY_RESERVATION_INFO_ID, params, rowMapper);
	}

	public int sumPrice(Integer reservationInfoId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("reservationInfoId", reservationInfoId);
		return jdbc.queryForObject(ReservationInfoPriceDaoSqls.GET_SUM_PRICE, params, Integer.class);
	}

}
