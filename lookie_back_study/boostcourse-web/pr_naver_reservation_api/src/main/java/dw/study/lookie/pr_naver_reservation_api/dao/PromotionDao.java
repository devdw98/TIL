package dw.study.lookie.pr_naver_reservation_api.dao;

import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import dw.study.lookie.pr_naver_reservation_api.dto.PromotionDto;
import dw.study.lookie.pr_naver_reservation_api.mapper.PromotionDtoMapper;

@Repository
public class PromotionDao {
	NamedParameterJdbcTemplate jdbc;
//	RowMapper<PromotionDto> rowMapper = BeanPropertyRowMapper.newInstance(PromotionDto.class);
	PromotionDtoMapper rowMapper = new PromotionDtoMapper();
	
	public PromotionDao(DataSource ds) {
		this.jdbc = new NamedParameterJdbcTemplate(ds);
	}
	
	public int selectCount() {
		return jdbc.queryForObject(PromotionDaoSqls.SELECT_COUNT, Collections.emptyMap(), Integer.class);
	}
	
	public List<PromotionDto> selectAll(){
		return jdbc.query(PromotionDaoSqls.SELECT_ALL, rowMapper);
	}
}
