package dw.study.lookie.w3_guestbook.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import dw.study.lookie.w3_guestbook.dto.Log;

@Repository
public class LogDao {
	SimpleJdbcInsert insertAction; // insert시 필요
	NamedParameterJdbcTemplate jdbc;

	public LogDao(DataSource ds) {
		this.jdbc = new NamedParameterJdbcTemplate(ds);
		this.insertAction = new SimpleJdbcInsert(ds).withTableName("log").usingGeneratedKeyColumns("id");
		//usingGeneratedKeyColumns : id 자동 입력되도록 하는 것
	}

	public Long insert(Log log) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(log);
		return insertAction.executeAndReturnKey(params).longValue();
		//insert 문은 내부적으로 생성해서 실행하고 자동으로 생성된 id값 리턴함
	}
}
