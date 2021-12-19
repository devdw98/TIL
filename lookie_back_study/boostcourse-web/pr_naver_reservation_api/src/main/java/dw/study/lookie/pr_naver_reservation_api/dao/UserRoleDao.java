package dw.study.lookie.pr_naver_reservation_api.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import dw.study.lookie.pr_naver_reservation_api.dto.UserRole;

@Repository
public class UserRoleDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<UserRole> rowMapper = BeanPropertyRowMapper.newInstance(UserRole.class);

	public UserRoleDao(DataSource ds) {
		this.jdbc = new NamedParameterJdbcTemplate(ds);
	}

	public List<UserRole> getRolesByEmail(String email){
		Map<String, Object> params = new HashMap<>();
		params.put("email", email);
		return jdbc.query(UserRoleDaoSqls.SELECT_ALL_BY_EMAIL, params, rowMapper);
	}
}
