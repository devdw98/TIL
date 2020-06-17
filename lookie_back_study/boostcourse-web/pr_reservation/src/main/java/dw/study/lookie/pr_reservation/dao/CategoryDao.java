package dw.study.lookie.pr_reservation.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import dw.study.lookie.pr_reservation.dto.Category;

@Repository
public class CategoryDao {
	
	NamedParameterJdbcTemplate jdbc;
	RowMapper<Category> rowMapper = BeanPropertyRowMapper.newInstance(Category.class);
	
	
	public CategoryDao(DataSource ds) {
		this.jdbc = new NamedParameterJdbcTemplate(ds);
	}
	
	public List<Category> selectCategory(){
		
		return jdbc.query(CategoryDaoSqls.SELECT_ALL, rowMapper);
	}
	
}
