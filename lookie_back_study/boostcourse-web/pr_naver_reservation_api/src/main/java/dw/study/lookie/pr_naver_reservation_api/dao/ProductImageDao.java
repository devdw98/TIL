package dw.study.lookie.pr_naver_reservation_api.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import dw.study.lookie.pr_naver_reservation_api.dto.ProductImageDto;
import dw.study.lookie.pr_naver_reservation_api.mapper.ProductImageDtoMapper;

@Repository
public class ProductImageDao {

	NamedParameterJdbcTemplate jdbc;
//	RowMapper<ProductImageDto> rowMapper = BeanPropertyRowMapper.newInstance(ProductImageDto.class);
	ProductImageDtoMapper rowMapper = new ProductImageDtoMapper();
	public ProductImageDao(DataSource ds) {
		this.jdbc = new NamedParameterJdbcTemplate(ds);
	}

	public List<ProductImageDto> selectAll(int productId) {
		Map<String, Object> params = new HashMap<>();
		params.put("productId", productId);
		return jdbc.query(ProductImageDaoSqls.SELECT_ALL_BY_PRODUCT, params, rowMapper);
	}
}
