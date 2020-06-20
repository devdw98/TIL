package dw.study.lookie.w5_securityexam.dao;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import dw.study.lookie.w5_securityexam.dto.Member;

@Repository
public class MemberDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Member> rowMapper = BeanPropertyRowMapper.newInstance(Member.class);
	
	public MemberDao(DataSource ds) {
		this.jdbc = new NamedParameterJdbcTemplate(ds);
	}
	
	public Member getMemberByEmail(String email) {
		Map<String, Object> params = new HashMap<>();
		params.put("email", email);
		return jdbc.queryForObject(MemberDaoSqls.SELECT_ALL_BY_EMAIL, params, rowMapper);
	}
	
}
