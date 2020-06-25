package dw.study.lookie.pr_naver_reservation_api.dao;

import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import dw.study.lookie.pr_naver_reservation_api.dto.CategoryDto;
import dw.study.lookie.pr_naver_reservation_api.mapper.CategoryDtoMapper;

@Repository
public class CategoryDao {
	NamedParameterJdbcTemplate jdbc;
//	RowMapper<CategoryDto> rowMapper = BeanPropertyRowMapper.newInstance(CategoryDto.class);
	RowMapper<CategoryDto> mapper = new CategoryDtoMapper();
	
	public CategoryDao(DataSource ds) {
		this.jdbc = new NamedParameterJdbcTemplate(ds);
	}

	public List<CategoryDto> selectAll() {
		return jdbc.query(CategoryDaoSqls.SELECT_CATEGORY_INFO, mapper);
	}

	public int selectCount() {
		return jdbc.queryForObject(CategoryDaoSqls.SELECT_COUNT, Collections.emptyMap(), Integer.class);
	}

}
