package dw.study.lookie.pr_naver_reservation_api.dao;

import java.util.Collections;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import dw.study.lookie.pr_naver_reservation_api.dto.ReservationDto;
@Repository
public class ReservationDao {
	NamedParameterJdbcTemplate jdbc;
	RowMapper<ReservationDto> rowMapper = BeanPropertyRowMapper.newInstance(ReservationDto.class);

	public ReservationDao(DataSource ds) {
		this.jdbc = new NamedParameterJdbcTemplate(ds);
	}

	public int changeCancelFlag(Integer reservationId) {
		Map<String, ?> params = Collections.singletonMap("id", reservationId);
		return jdbc.update(ReservationDaoSqls.CHANGE_CANCEL_FLAG, params);
	}
}
