package dw.study.lookie.pr_naver_reservation_api.dao;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import dw.study.lookie.pr_naver_reservation_api.dto.User;

@Repository //db정보 읽는 레이어
public class UserDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<User> rowMapper = BeanPropertyRowMapper.newInstance(User.class);
	public UserDao(DataSource ds) {
		this.jdbc = new NamedParameterJdbcTemplate(ds);
	}
	
	public User getUserByEmail(String email) {
		Map<String, Object> params = new HashMap<>();
		params.put("email", email);
		return jdbc.queryForObject(UserDaoSqls.SELECT_ALL_BY_EMAIL, params, rowMapper);
	}
	
	
}
