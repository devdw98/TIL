package dw.study.lookie.pr_naver_reservation_api.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dw.study.lookie.pr_naver_reservation_api.dto.CategoryDto;
import dw.study.lookie.pr_naver_reservation_api.vo.Category;

public class CategoryDtoMapper implements RowMapper<CategoryDto> {
	public CategoryDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		CategoryDto dto = new CategoryDto();
		dto.setCategory(new Category(rs.getInt("id"), rs.getString("name")));
		dto.setCount(rs.getInt("count"));
		return dto;
	}

}
