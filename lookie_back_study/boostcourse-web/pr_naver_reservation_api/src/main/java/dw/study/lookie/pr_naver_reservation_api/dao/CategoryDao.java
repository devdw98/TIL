package dw.study.lookie.pr_naver_reservation_api.dao;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import dw.study.lookie.pr_naver_reservation_api.dto.Category;

@Repository
public class CategoryDao {
	NamedParameterJdbcTemplate jdbc;
	RowMapper<Category> rowMapper = BeanPropertyRowMapper.newInstance(Category.class);

	public CategoryDao(DataSource ds) {
		this.jdbc = new NamedParameterJdbcTemplate(ds);
	}

	public int selectCount() {
		return jdbc.queryForObject(CategoryDaoSqls.SELECT_COUNT, Collections.emptyMap(), Integer.class);
	}

	public List<Category> selectAll() {
		return jdbc.query(CategoryDaoSqls.SELECT_CATEGORY_INFO, rowMapper);
	}

}
