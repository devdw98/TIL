package dw.study.lookie.pr_naver_reservation_api.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import dw.study.lookie.pr_naver_reservation_api.dto.ProductDto;
import dw.study.lookie.pr_naver_reservation_api.mapper.ProductDtoMapper;

@Repository
public class ProductDao {
	NamedParameterJdbcTemplate jdbc;
//	RowMapper<ProductDto> rowMapper = BeanPropertyRowMapper.newInstance(ProductDto.class);
	ProductDtoMapper rowMapper = new ProductDtoMapper(); //productId 는 왜 뜨는지 모르겠음 
	public ProductDao(DataSource ds) {
		this.jdbc = new NamedParameterJdbcTemplate(ds);
	}
	
	public Integer getProductId(Integer displayInfoId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("displayInfoId",displayInfoId);
		return jdbc.queryForObject(ProductDaoSqls.GET_PRODUCT_ID, params, Integer.class);
	}

	public List<ProductDto> selectAllDisplayInfos(Integer start, Integer end) {
		Map<String, Integer> params = new HashMap<>();
		params.put("start", start);
		params.put("end", end);
		return jdbc.query(ProductDaoSqls.SELECT_ALL, params, rowMapper);
	}

	public int countAllDisplayInfo(Integer categoryId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("categoryId", categoryId);
		return jdbc.queryForObject(ProductDaoSqls.SELECT_ALL_COUNT, params, Integer.class);
	}

	public List<ProductDto> selectDisplayInfosByCategory(Integer categoryId, Integer start, Integer end) {
		Map<String, Integer> params = new HashMap<>();
		params.put("categoryId", categoryId);
		params.put("start", start);
		params.put("end", end);
		return jdbc.query(ProductDaoSqls.SELECT_BY_CATEGORY, params, rowMapper);
	}

	public int countDisplayInfoByCategory(Integer categoryId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("categoryId", categoryId);
		return jdbc.queryForObject(ProductDaoSqls.SELECT_COUNT_BY_CATEGORY, params, Integer.class);
	}

	public ProductDto selectDisplayInfo(Integer displayId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("displayId", displayId);
		return jdbc.queryForObject(ProductDaoSqls.SELECT_DISPLAY_INFO, params, rowMapper);
	}

}
