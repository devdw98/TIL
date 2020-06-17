package dw.study.lookie.pr_reservation.dao;

import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import dw.study.lookie.pr_reservation.dto.Promotion;

@Repository
public class PromotionDao {
	NamedParameterJdbcTemplate jdbc;
	RowMapper<Promotion> rowMapper = BeanPropertyRowMapper.newInstance(Promotion.class);
	
	public PromotionDao(DataSource ds) {
		this.jdbc = new NamedParameterJdbcTemplate(ds);
	}
	
	public List<Promotion> selectPromotion(){
		return jdbc.query(PromotionDaoSqls.SELECT_ALL, rowMapper);
	}
	
	public int selectCount() {
		return jdbc.queryForObject(PromotionDaoSqls.SELECT_COUNT, Collections.emptyMap(), Integer.class);
	}
}
