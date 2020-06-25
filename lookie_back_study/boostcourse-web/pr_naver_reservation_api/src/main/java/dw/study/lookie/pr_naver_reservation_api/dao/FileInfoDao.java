package dw.study.lookie.pr_naver_reservation_api.dao;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import dw.study.lookie.pr_naver_reservation_api.vo.FileInfo;

@Repository
public class FileInfoDao {
	NamedParameterJdbcTemplate jdbc;
	RowMapper<FileInfo> rowMapper = BeanPropertyRowMapper.newInstance(FileInfo.class);
	
	public FileInfoDao(DataSource ds) {
		this.jdbc = new NamedParameterJdbcTemplate(ds);
	}
	
	public FileInfo selectAll(Integer fileId) {
		Map<String, Integer> params = new HashMap<>();
		params.put("fileId", fileId);
		return jdbc.queryForObject(FileInfoDaoSqls.SELECT_ALL, params, rowMapper);
	}
}
