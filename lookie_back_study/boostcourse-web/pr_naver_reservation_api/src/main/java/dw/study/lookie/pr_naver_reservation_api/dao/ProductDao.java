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

	public int selectAllCount() {
		return jdbc.queryForObject(ProductDaoSqls.SELECT_ALL_COUNT, Collections.emptyMap(), Integer.class);
	}

//	public int selectPagingCount() {
//		return jdbc.queryForObject(ProductDaoSqls.SELECT_PAGING, Collections.emptyMap(), Integer.class);
//	}
	public List<Product> selectProductInfo(Integer categoryId, Integer start, Integer limit) {
		Map<String, Integer> params = new HashMap<>();
		params.put("categoryId", categoryId);
		params.put("start", start);
		params.put("limit", limit);
		return jdbc.query(ProductDaoSqls.SELECT_PRODUCTS_INFO, params, rowMapper);
	}

}
