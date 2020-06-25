package dw.study.lookie.pr_naver_reservation_api.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import dw.study.lookie.pr_naver_reservation_api.dto.ReservationInfoDto;
import dw.study.lookie.pr_naver_reservation_api.mapper.ReservationInfoDtoMapper;

@Repository
public class ReservationInfoDao { //주문정보 구하기
	NamedParameterJdbcTemplate jdbc;
//	RowMapper<ReservationDto> rowMapper = BeanPropertyRowMapper.newInstance(ReservationDto.class);
	ReservationInfoDtoMapper rowMapper = new ReservationInfoDtoMapper();
	SimpleJdbcInsert insertAction;
	
	public ReservationInfoDao(DataSource ds) {
		this.jdbc = new NamedParameterJdbcTemplate(ds);
		this.insertAction = new SimpleJdbcInsert(ds);
	}
	
//	public Long insert(Guestbook gb) {
//		SqlParameterSource params = new BeanPropertySqlParameterSource(gb);
//		return insertAction.executeAndReturnKey(params).longValue();
//	}
	
//	public int insertReservationInfo(ReservationDto reservationInfo) {
//		SqlParameterSource params = new BeanPropertySqlParameterSource(reservationInfo);
//		return insertAction.executeAndReturnKey(params).intValue();
//	}
	
	public List<ReservationInfoDto> selectReservationInfoList(Integer userId){
		Map<String, Object> params = new HashMap<>();
		params.put("userId", userId);
		return jdbc.query(ReservationInfoDaoSqls.SELECT_ALL_BY_RESERVATION_INFO, params, rowMapper);
	}
	
	public int selectReservationInfoCount(Integer userId) {
		Map<String, Object> params = new HashMap<>();
		params.put("userId", userId);
		return jdbc.queryForObject(ReservationInfoDaoSqls.SELECT_RESERVATION_INFO_COUNT, params, Integer.class);
	}

	
}
