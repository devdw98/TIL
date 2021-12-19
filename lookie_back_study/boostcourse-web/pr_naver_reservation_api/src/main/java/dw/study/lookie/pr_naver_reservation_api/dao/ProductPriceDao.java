package dw.study.lookie.pr_naver_reservation_api.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import dw.study.lookie.pr_naver_reservation_api.dto.ProductPriceDto;
import dw.study.lookie.pr_naver_reservation_api.mapper.ProductPriceDtoMapper;

@Repository
public class ProductPriceDao {
	NamedParameterJdbcTemplate jdbc;
//	RowMapper<ProductPriceDto> rowMapper = BeanPropertyRowMapper.newInstance(ProductPriceDto.class);
	ProductPriceDtoMapper rowMapper = new ProductPriceDtoMapper();

	public ProductPriceDao(DataSource ds) {
		this.jdbc = new NamedParameterJdbcTemplate(ds);
	}

	public List<ProductPriceDto> selectAll(int productId) {
		Map<String, Object> params = new HashMap<>();
		params.put("productId", productId);
		return jdbc.query(ProductPriceDaoSqls.SELECT_ALL_BY_PRICE, params, rowMapper);
	}

}
