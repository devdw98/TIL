package dw.study.lookie.pr_naver_reservation_api.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import dw.study.lookie.pr_naver_reservation_api.dto.DisplayInfoImageDto;
import dw.study.lookie.pr_naver_reservation_api.mapper.DisplayInfoImageDtoMapper;

@Repository
public class DisplayInfoImageDao {
	NamedParameterJdbcTemplate jdbc;
//	RowMapper<DisplayInfoImageDto> rowMapper = BeanPropertyRowMapper.newInstance(DisplayInfoImageDto.class);
	DisplayInfoImageDtoMapper rowMapper = new DisplayInfoImageDtoMapper();
	public DisplayInfoImageDao(DataSource ds) {
		this.jdbc = new NamedParameterJdbcTemplate(ds);
	}

	public List<DisplayInfoImageDto> selectAll(int displayInfoId) {
		Map<String, Object> params = new HashMap<>();
		params.put("displayInfoId", displayInfoId);
		return jdbc.query(DisplayInfoImageDaoSqls.SELECT_ALL_BY_DISPLAY, params, rowMapper);
	}
}
