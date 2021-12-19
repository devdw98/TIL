package dw.study.lookie.pr_naver_reservation_api.dao;

import java.util.Collections;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import dw.study.lookie.pr_naver_reservation_api.dto.ReservationDto;

@Repository
public class ReservationDao {
	NamedParameterJdbcTemplate jdbc;
	RowMapper<ReservationDto> rowMapper = BeanPropertyRowMapper.newInstance(ReservationDto.class);
	SimpleJdbcInsert insertAction;

	public ReservationDao(DataSource ds) {
		this.jdbc = new NamedParameterJdbcTemplate(ds);
		this.insertAction = new SimpleJdbcInsert(ds);
	}

//	public Long insert(Guestbook gb) {
//	SqlParameterSource params = new BeanPropertySqlParameterSource(gb);
//	return insertAction.executeAndReturnKey(params).longValue();
//}

//public int insertReservationInfo(ReservationDto reservationInfo) {
//	SqlParameterSource params = new BeanPropertySqlParameterSource(reservationInfo);
//	return insertAction.executeAndReturnKey(params).intValue();
//}


}
