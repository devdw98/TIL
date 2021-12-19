package dw.study.lookie.pr_naver_reservation_api.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dw.study.lookie.pr_naver_reservation_api.dto.PromotionDto;
import dw.study.lookie.pr_naver_reservation_api.vo.Category;
import dw.study.lookie.pr_naver_reservation_api.vo.Promotion;

public class PromotionDtoMapper implements RowMapper<PromotionDto>{

	public PromotionDto mapRow(ResultSet rs, int rowNum) throws SQLException{
		PromotionDto dto = new PromotionDto();
		dto.setPromotion(new Promotion(rs.getInt("id"), rs.getInt("productId")));
		dto.setCategory(new Category(rs.getInt("categoryId"), rs.getString("categoryName")));
		dto.setDescription(rs.getString("description"));
		dto.setFileId(rs.getInt("fileId"));
		return dto;
	}
}
