package dw.study.lookie.w3_daoexam.dao;

import static dw.study.lookie.w3_daoexam.dao.RoleDaoSqls.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import dw.study.lookie.w3_daoexam.dto.Role;
@Repository //dao 는 저장소 역할이라 해당 어노테이션 붙임
public class RoleDao {
	//NamedParameterJDBC 사용하기 위한 선언들
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction; //insert 하기 위해선 simplejdbcinsert 필요
	private RowMapper<Role> rowMapper =  BeanPropertyRowMapper.newInstance(Role.class);
	
	public RoleDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("role");
	}
	
	public List<Role> selectAll(){
		return jdbc.query(SELECT_ALL, Collections.emptyMap(), rowMapper);
		//emptyMap: sql에 바인딩할 값이 있을 경우에 바인딩할 값을 전달할 목적으로사용
		//rowMapper: select 한 건 한 건의 결과를 자동으로 dto에 저장하는 목적으로 사용
	}
	
	public int insert(Role role) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(role);
		return insertAction.execute(params);
	}
	public int update(Role role) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(role);
		return jdbc.update(UPDATE, params);
	}
	public Role selectById(Integer id) {
		try {
			Map<String,?> params = Collections.singletonMap("roleId", id);
			return jdbc.queryForObject(SELECT_BY_ROLE_ID, params, rowMapper);
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	public int deleteById(Integer id) {
		Map<String,?> params = Collections.singletonMap("roleId", id); //한 건만 넣을 때 싱글톤맵 사용
		return jdbc.update(DELETE_BY_ROLE_ID, params);
	}
	
}
