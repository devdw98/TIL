package dw.study.lookie.pr_naver_reservation_api.dao;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import dw.study.lookie.pr_naver_reservation_api.dto.ReservationInfoDto;
import dw.study.lookie.pr_naver_reservation_api.mapper.ReservationInfoDtoMapper;
import dw.study.lookie.pr_naver_reservation_api.vo.ReservationInfo;

@Repository
public class ReservationInfoDao { // 주문정보 구하기
	NamedParameterJdbcTemplate jdbc;
//	RowMapper<ReservationDto> rowMapper = BeanPropertyRowMapper.newInstance(ReservationDto.class);
	ReservationInfoDtoMapper rowMapper = new ReservationInfoDtoMapper();
	SimpleJdbcInsert insertAction;

	public ReservationInfoDao(DataSource ds) {
		this.jdbc = new NamedParameterJdbcTemplate(ds);
		this.insertAction = new SimpleJdbcInsert(ds);
	}

	public List<ReservationInfoDto> selectReservationInfoList(Integer userId) {
		Map<String, Object> params = new HashMap<>();
		params.put("userId", userId);
		return jdbc.query(ReservationInfoDaoSqls.SELECT_ALL_BY_RESERVATION_INFO, params, rowMapper);
	}

	public int selectReservationInfoCount(Integer userId) {
		Map<String, Object> params = new HashMap<>();
		params.put("userId", userId);
		return jdbc.queryForObject(ReservationInfoDaoSqls.SELECT_RESERVATION_INFO_COUNT, params, Integer.class);
	}

	public int insertReservationInfo(ReservationInfo reservationInfo) {
//		SqlParameterSource params = new BeanPropertySqlParameterSource(reservationInfo);
//		return insertAction.executeAndReturnKey(params).intValue();
		Map<String, Object> params = new HashMap<>();
		params.put("productId",reservationInfo.getProductId());
		params.put("displayInfoId", reservationInfo.getDisplayInfoId());
		params.put("userId",reservationInfo.getUserId());
		params.put("reservationDate", reservationInfo.getReservationDate());
		params.put("cancelFlag", 0);
		params.put("createDate", new Date());
		params.put("modifyDate", new Date());
		return jdbc.update(ReservationInfoDaoSqls.INSERT, params);
	}

	public ReservationInfoDto selectReservation(int id) { // insert 후 정보 조회
		Map<String, ?> params = Collections.singletonMap("id", id);
		return jdbc.queryForObject(ReservationInfoDaoSqls.SELECT_RESERVATION, params, rowMapper);
	}

	public int changeCancelFlag(Integer userId, Integer reservationId) {
//		Map<String, ?> params = Collections.singletonMap("id", reservationId);
		Map<String, Integer> params = new HashMap<>();
		params.put("user_id", userId);
		params.put("id", reservationId);
		return jdbc.update(ReservationInfoDaoSqls.CHANGE_CANCEL_FLAG, params);
	}
	
	public int changeModifyDate(Integer userId, Integer reservationId) {
//		Map<String, ?> params = Collections.singletonMap("id", reservationId);
		Map<String, Integer> params = new HashMap<>();
		params.put("user_id", userId);
		params.put("id", reservationId);
		return jdbc.update(ReservationInfoDaoSqls.CHANGE_MODIFY_DATE, params);
	}
}
