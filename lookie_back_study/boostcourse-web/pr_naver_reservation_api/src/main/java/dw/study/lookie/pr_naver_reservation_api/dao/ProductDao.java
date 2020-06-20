package dw.study.lookie.pr_naver_reservation_api.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import dw.study.lookie.pr_naver_reservation_api.dto.DisplayInfoImage;
import dw.study.lookie.pr_naver_reservation_api.dto.Product;
import dw.study.lookie.pr_naver_reservation_api.dto.ProductImage;
import dw.study.lookie.pr_naver_reservation_api.dto.ProductPrice;
import dw.study.lookie.pr_naver_reservation_api.dto.ReservationUserComment;
import dw.study.lookie.pr_naver_reservation_api.dto.ReservationUserCommentImage;

@Repository
public class ProductDao {
	NamedParameterJdbcTemplate jdbc;
	RowMapper<Product> rowMapperProduct = BeanPropertyRowMapper.newInstance(Product.class);

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
		return jdbc.query(ProductDaoSqls.SELECT_ALL_PRODUCTS_INFO, params, rowMapperProduct);
	}

	public List<Product> selectProductsInfoByCategory(Integer categoryId, Integer start, Integer end) {
		Map<String, Integer> params = new HashMap<>();
		params.put("categoryId", categoryId);
		params.put("start", start);
		params.put("end", end);
		return jdbc.query(ProductDaoSqls.SELECT_PRODUCTS_INFO, params, rowMapperProduct);
	}

	public Product selectProductInfo(Integer displayId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("displayId", displayId);
		return jdbc.queryForObject(ProductDaoSqls.SELECT_PRODUCT_INFO, params, rowMapperProduct);
	}

	public List<ProductImage> selectProductImageInfo(Integer displayId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("displayId", displayId);
		return jdbc.query(ProductDaoSqls.SELECT_PRODUCT_IMAGE, params, BeanPropertyRowMapper.newInstance(ProductImage.class));
	}

	public List<DisplayInfoImage> selectDisplayInfoImageInfo(Integer displayId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("displayId", displayId);
		return jdbc.query(ProductDaoSqls.SELECT_DISPLAYINFO_IMAGE, params, BeanPropertyRowMapper.newInstance(DisplayInfoImage.class));
	}

	public List<ProductPrice> selectProductPriceInfo(Integer displayId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("displayId", displayId);
		return jdbc.query(ProductDaoSqls.SELECT_PRODUCT_PRICE, params, BeanPropertyRowMapper.newInstance(ProductPrice.class));
	}
	
	public List<Integer> selectDisplayInfoScore(Integer displayId){
		Map<String, Integer> params = new HashMap<>();
		params.put("displayId", displayId);
		return jdbc.queryForList(ProductDaoSqls.SELECT_PRODUCT_SCORE, params,Integer.class);
	}
	
	public int selectCountProductComments(Integer productId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("productId", productId);
		return jdbc.queryForObject(ProductDaoSqls.SELECT_COUNT_PRODUCT_COMMENT, params, Integer.class);
	}
	
	public List<ReservationUserComment> selectProductComments(Integer productId, Integer start, Integer end){
		Map<String, Integer> params = new HashMap<>();
		params.put("productId", productId);
		params.put("start", start);
		params.put("end", end);
		return jdbc.query(ProductDaoSqls.SELECT_PRODUCT_RESERVATION_USER_COMMENTS, params, BeanPropertyRowMapper.newInstance(ReservationUserComment.class));
	}
	
	public List<ReservationUserCommentImage> selectProductCommentImages(Integer commentId ){
		Map<String, Integer> params = new HashMap<>();
		params.put("commentId", commentId);
		return jdbc.query(ProductDaoSqls.SELECT_PRODUCT_RESERVATION_USER_COMMENTS_IMAGE, params, BeanPropertyRowMapper.newInstance(ReservationUserCommentImage.class));
	}

}
