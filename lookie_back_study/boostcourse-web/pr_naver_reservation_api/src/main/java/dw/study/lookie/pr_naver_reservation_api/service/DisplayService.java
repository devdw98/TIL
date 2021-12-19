package dw.study.lookie.pr_naver_reservation_api.service;

import java.util.List;

import dw.study.lookie.pr_naver_reservation_api.dto.CommentDto;
import dw.study.lookie.pr_naver_reservation_api.dto.DisplayInfoImageDto;
import dw.study.lookie.pr_naver_reservation_api.dto.ProductDto;
import dw.study.lookie.pr_naver_reservation_api.dto.ProductImageDto;
import dw.study.lookie.pr_naver_reservation_api.dto.ProductPriceDto;
import dw.study.lookie.pr_naver_reservation_api.vo.FileInfo;

public interface DisplayService {
	public static final Integer LIMIT = 5;

	public ProductDto getDisplayInfo(Integer displayId);

	public List<ProductImageDto> getProductImageInfoList(Integer displayId);

	public List<DisplayInfoImageDto> getDisplayInfoImageList(Integer displayId);

	public List<ProductPriceDto> getProductPriceList(Integer displayId);

	public int getAvgScore(Integer displayId);

	public int getCountComment(Integer productId);

	public List<CommentDto> getCommentList(Integer productId, Integer start);
//	public Map<String, Object> getComment(Integer commentId, Integer start);
	public FileInfo getFileInfo(Integer fileId);
}
