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

import dw.study.lookie.pr_naver_reservation_api.dto.Product;

@Repository
public class ProductDao {
	NamedParameterJdbcTemplate jdbc;
	RowMapper<Product> rowMapper = BeanPropertyRowMapper.newInstance(Product.class);

	public ProductDao(DataSource ds) {
		this.jdbc = new NamedParameterJdbcTemplate(ds);
	}

	public int selecAllProductsCount() {
		return jdbc.queryForObject(ProductDaoSqls.SELECT_COUNT_ALL_PRODUCTS, Collections.emptyMap(), Integer.class);
	}

	public int selectCountProductByCategory(Integer categoryId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("categoryId", categoryId);
		return jdbc.queryForObject(ProductDaoSqls.SELECT_COUNT_PRODUCTS_BY_CATEGORY, params, Integer.class);
	}

	public List<Product> selectAllProductsInfo(Integer start, Integer end) {
		Map<String, Integer> params = new HashMap<>();
		params.put("start", start);
		params.put("end", end);
		return jdbc.query(ProductDaoSqls.SELECT_ALL_PRODUCTS_INFO, params, rowMapper);
	}

	public List<Product> selectProductsInfoByCategory(Integer categoryId, Integer start, Integer end) {
		Map<String, Integer> params = new HashMap<>();
		params.put("categoryId", categoryId);
		params.put("start", start);
		params.put("end", end);
		return jdbc.query(ProductDaoSqls.SELECT_PRODUCTS_INFO, params, rowMapper);
	}

}
