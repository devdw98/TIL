package dw.study.lookie.pr_naver_reservation_api.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import dw.study.lookie.pr_naver_reservation_api.dto.CommentImageDto;
import dw.study.lookie.pr_naver_reservation_api.mapper.CommentImageDtoMapper;

@Repository
public class CommentImageDao {
	NamedParameterJdbcTemplate jdbc;
//	RowMapper<CommentImageDto> rowMapper = BeanPropertyRowMapper.newInstance(CommentImageDto.class);
	CommentImageDtoMapper rowMapper = new CommentImageDtoMapper();

	public CommentImageDao(DataSource ds) {
		this.jdbc = new NamedParameterJdbcTemplate(ds);

	}
	
//	public List<Integer> selectCommentId(Integer commentId){
//		List<Integer> list = jdbc.queryForList(sql, paramMap);
//	}

	public List<CommentImageDto> selectAll(Integer commentId) {
		Map<String, Integer> params = new HashMap();
		params.put("commentId", commentId);
		return jdbc.query(CommentImageDaoSqls.SELECT_ALL, params, rowMapper);
	}

}
