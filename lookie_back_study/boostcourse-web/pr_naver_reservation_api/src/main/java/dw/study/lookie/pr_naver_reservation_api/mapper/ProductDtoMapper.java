package dw.study.lookie.pr_naver_reservation_api.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dw.study.lookie.pr_naver_reservation_api.dto.ProductDto;

public class ProductDtoMapper implements RowMapper<ProductDto>{
	public ProductDto mapRow(ResultSet rs, int rowNum) throws SQLException{
		ProductDto dto = new ProductDto();
		dto.setId(rs.getInt("id"));
		dto.setCategoryId(rs.getInt("categoryId"));
		dto.setDisplayInfoId(rs.getInt("displayInfoId"));
		dto.setName(rs.getString("name"));
		dto.setDescription(rs.getString("description"));
		dto.setContent(rs.getString("content"));
		dto.setEvent(rs.getString("event"));
		dto.setOpeningHours(rs.getString("opening_hours"));
		dto.setPlaceName(rs.getString("place_name"));
		dto.setPlaceLot(rs.getString("place_lot"));
		dto.setPlaceStreet(rs.getString("place_street"));
		dto.setTel(rs.getString("tel"));
		dto.setHomepage(rs.getString("homepage"));
		dto.setEmail(rs.getString("email"));
		dto.setCreateDate(rs.getDate("create_date"));
		dto.setModifyDate(rs.getDate("modify_date"));
		dto.setFileId(rs.getInt("fileId"));
		return dto;
	}
}
