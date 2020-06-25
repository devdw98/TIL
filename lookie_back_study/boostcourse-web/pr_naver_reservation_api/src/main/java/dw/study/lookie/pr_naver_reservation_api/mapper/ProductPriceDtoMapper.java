package dw.study.lookie.pr_naver_reservation_api.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dw.study.lookie.pr_naver_reservation_api.dto.ProductPriceDto;
import dw.study.lookie.pr_naver_reservation_api.vo.DateInfo;
import dw.study.lookie.pr_naver_reservation_api.vo.ProductPrice;

public class ProductPriceDtoMapper implements RowMapper<ProductPriceDto>{

	@Override
	public ProductPriceDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductPriceDto dto = new ProductPriceDto();
		ProductPrice price = new ProductPrice();
		DateInfo dateInfo = new DateInfo();
		dateInfo.setCreateDate(rs.getDate("create_date"));
		dateInfo.setModifyDate(rs.getDate("modify_date"));
		price.setId(rs.getInt("id"));
		price.setProductId(rs.getInt("product_id"));
		price.setPriceTypeName(rs.getString("price_type_name"));
		price.setPrice(rs.getInt("price"));
		price.setDiscountRate(rs.getInt("discount_rate"));
		price.setDateInfo(dateInfo);
		dto.setPrice(price);
		return dto;
	}

}
