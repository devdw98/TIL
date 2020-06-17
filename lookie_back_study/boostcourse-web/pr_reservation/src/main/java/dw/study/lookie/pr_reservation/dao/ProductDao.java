package dw.study.lookie.pr_reservation.dao;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import dw.study.lookie.pr_reservation.dto.Product;

@Repository
public class ProductDao {
	NamedParameterJdbcTemplate jdbc;
	RowMapper<Product> rowMapper = BeanPropertyRowMapper.newInstance(Product.class);
	
	public ProductDao(DataSource ds) {
		this.jdbc = new NamedParameterJdbcTemplate(ds);
	}
	
	public List<Product> selectAllProduct(){
		return jdbc.query(ProductDaoSqls.SELECT_ALL, rowMapper);
	}
	
	public List<Product> selectProductsFromCategory(Integer categoryId){
		Map<String, Integer> params = new HashMap<>();
		params.put("categoryId", categoryId);
		return jdbc.query(ProductDaoSqls.SELECT_FROM_CATEGORY, params, rowMapper);
	}

	public int countAllProducts() {
		return jdbc.queryForObject(ProductDaoSqls.COUNT_ALL_PRODUCTS, Collections.emptyMap(), Integer.class);
	}
	
	public int countProductInCategory(int categoryId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("categoryId", categoryId);
		return jdbc.queryForObject(ProductDaoSqls.COUNT_CATEGORY_PRODUCTS,Collections.emptyMap(), Integer.class);
	}
}
