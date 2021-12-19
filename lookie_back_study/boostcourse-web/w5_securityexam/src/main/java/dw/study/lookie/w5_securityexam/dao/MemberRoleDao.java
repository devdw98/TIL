package dw.study.lookie.w5_securityexam.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import dw.study.lookie.w5_securityexam.dto.MemberRole;

@Repository
public class MemberRoleDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<MemberRole> rowMapper = BeanPropertyRowMapper.newInstance(MemberRole.class);

	public MemberRoleDao(DataSource ds) {
		this.jdbc = new NamedParameterJdbcTemplate(ds);
	}
	
	public List<MemberRole> getRolesByEmail(String email){
		Map<String, Object> params = new HashMap<>();
		params.put("email", email);
		return jdbc.query(MemberRoleDaoSqls.SELECT_ALL_BY_EMAIL, params, rowMapper);
	}
}
