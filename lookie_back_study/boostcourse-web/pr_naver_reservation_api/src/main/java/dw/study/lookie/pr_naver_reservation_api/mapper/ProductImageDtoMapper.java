package dw.study.lookie.pr_naver_reservation_api.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dw.study.lookie.pr_naver_reservation_api.dto.ProductImageDto;
import dw.study.lookie.pr_naver_reservation_api.vo.DateInfo;
import dw.study.lookie.pr_naver_reservation_api.vo.FileInfo;
import dw.study.lookie.pr_naver_reservation_api.vo.ProductImage;

public class ProductImageDtoMapper implements RowMapper<ProductImageDto> {

	@Override
	public ProductImageDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductImageDto dto = new ProductImageDto();
		FileInfo fileInfo = new FileInfo();
		ProductImage image = new ProductImage();
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
		image.setProductId(rs.getInt("product_id"));
		image.setType(rs.getString("type"));
		dto.setFileInfo(fileInfo);
		dto.setImage(image);
		
		return dto;
	}

}
