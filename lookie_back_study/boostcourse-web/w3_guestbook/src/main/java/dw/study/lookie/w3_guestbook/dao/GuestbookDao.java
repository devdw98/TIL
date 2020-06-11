package dw.study.lookie.w3_guestbook.dao;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import dw.study.lookie.w3_guestbook.dto.Guestbook;
import static dw.study.lookie.w3_guestbook.dao.GuestbookDaoSqls.*;

@Repository
public class GuestbookDao {
	SimpleJdbcInsert insertAction;
	NamedParameterJdbcTemplate jdbc;
	RowMapper<Guestbook> rowMapper = BeanPropertyRowMapper.newInstance(Guestbook.class);

	public GuestbookDao(DataSource ds) {
		this.jdbc = new NamedParameterJdbcTemplate(ds);
		this.insertAction = new SimpleJdbcInsert(ds).withTableName("guestbook").usingGeneratedKeyColumns("id");
	}

	public Long insert(Guestbook gb) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(gb);
		return insertAction.executeAndReturnKey(params).longValue();
	}

	public List<Guestbook> selectAll(Integer start, Integer limit) {
		Map<String, Integer> params = new HashMap<>();
		params.put("start", start);
		params.put("limit", limit);
		
		return jdbc.query(SELECT_PAGING,  params, rowMapper);
	}

	public int selectCount() {
		return jdbc.queryForObject(SELECT_COUNT, Collections.emptyMap(), Integer.class);
	}

	public int deleteById(Long id) {
		Map<String, ?> params = Collections.singletonMap("id", id);
		return jdbc.update(DELETE_BY_ID, params);
	}

}
