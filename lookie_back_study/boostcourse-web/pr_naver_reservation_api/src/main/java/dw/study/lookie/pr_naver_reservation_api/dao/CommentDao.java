package dw.study.lookie.pr_naver_reservation_api.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import dw.study.lookie.pr_naver_reservation_api.dto.CommentDto;
import dw.study.lookie.pr_naver_reservation_api.mapper.CommentDtoMapper;

@Repository
public class CommentDao {
	NamedParameterJdbcTemplate jdbc;
//	RowMapper<CommentDto> rowMapper = BeanPropertyRowMapper.newInstance(CommentDto.class);
	CommentDtoMapper rowMapper = new CommentDtoMapper();

	public CommentDao(DataSource ds) {
		this.jdbc = new NamedParameterJdbcTemplate(ds);
	}

	public int countCommentByProduct(int productId) {
		Map<String, Object> params = new HashMap<>();
		params.put("productId", productId);
		return jdbc.queryForObject(CommentDaoSqls.COUNT_BY_PRODUCT, params, Integer.class);
	}

	public List<CommentDto> selectAllComments(Integer productId, Integer start, Integer end) {
		Map<String, Object> params = new HashMap<>();
		params.put("productId", productId);
		params.put("start", start);
		params.put("end", end);

		return jdbc.query(CommentDaoSqls.SELECT_ALL_BY_PRODUCT, params, rowMapper);
	}

	public List<Integer> getCommentId(Integer productId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("productId", productId);

		return jdbc.queryForList(CommentDaoSqls.SELECT_COMMENTID_LIST, params, Integer.class);

	}

	public CommentDto selectCommentByCommentId(Integer commentId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("commentId", commentId);
		return jdbc.queryForObject(CommentDaoSqls.SELECT_COMMENT_BY_COMMENT_ID, params, rowMapper);
	}

}
