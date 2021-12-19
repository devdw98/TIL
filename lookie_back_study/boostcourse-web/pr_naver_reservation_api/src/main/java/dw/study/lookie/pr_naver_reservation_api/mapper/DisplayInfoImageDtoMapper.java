package dw.study.lookie.pr_naver_reservation_api.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dw.study.lookie.pr_naver_reservation_api.dto.DisplayInfoImageDto;
import dw.study.lookie.pr_naver_reservation_api.vo.DateInfo;
import dw.study.lookie.pr_naver_reservation_api.vo.DisplayInfoImage;
import dw.study.lookie.pr_naver_reservation_api.vo.FileInfo;

public class DisplayInfoImageDtoMapper implements RowMapper<DisplayInfoImageDto>{

	@Override
	public DisplayInfoImageDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		DisplayInfoImageDto dto = new DisplayInfoImageDto();
		FileInfo fileInfo = new FileInfo();
		DisplayInfoImage image = new DisplayInfoImage();
		DateInfo date = new DateInfo();
		date.setCreateDate(rs.getDate("create_date"));
		date.setModifyDate(rs.getDate("modify_date"));
		fileInfo.setId(rs.getInt("fileInfoId"));
		fileInfo.setFileName(rs.getString("file_name"));
		fileInfo.setSaveFileName(rs.getString("save_file_name"));
		fileInfo.setConentType(rs.getString("content_type"));
		fileInfo.setDeleteFlag(rs.getInt("delete_flag"));
		fileInfo.setDateInfo(date);
		image.setId(rs.getInt("id"));
		image.setDisplayInfoId(rs.getInt("display_info_id"));
//		image.setFileId(rs.getString("fi"));
		dto.setFileInfo(fileInfo);
		dto.setImage(image);
		
		return dto;
	}

}
