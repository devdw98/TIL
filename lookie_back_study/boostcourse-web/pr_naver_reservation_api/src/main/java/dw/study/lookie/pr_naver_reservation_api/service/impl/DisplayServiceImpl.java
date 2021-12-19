package dw.study.lookie.pr_naver_reservation_api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dw.study.lookie.pr_naver_reservation_api.dao.CommentDao;
import dw.study.lookie.pr_naver_reservation_api.dao.CommentImageDao;
import dw.study.lookie.pr_naver_reservation_api.dao.DisplayInfoImageDao;
import dw.study.lookie.pr_naver_reservation_api.dao.FileInfoDao;
import dw.study.lookie.pr_naver_reservation_api.dao.ProductDao;
import dw.study.lookie.pr_naver_reservation_api.dao.ProductImageDao;
import dw.study.lookie.pr_naver_reservation_api.dao.ProductPriceDao;
import dw.study.lookie.pr_naver_reservation_api.dto.CommentDto;
import dw.study.lookie.pr_naver_reservation_api.dto.DisplayInfoImageDto;
import dw.study.lookie.pr_naver_reservation_api.dto.ProductDto;
import dw.study.lookie.pr_naver_reservation_api.dto.ProductImageDto;
import dw.study.lookie.pr_naver_reservation_api.dto.ProductPriceDto;
import dw.study.lookie.pr_naver_reservation_api.service.DisplayService;
import dw.study.lookie.pr_naver_reservation_api.vo.FileInfo;

@Service
public class DisplayServiceImpl implements DisplayService {
	@Autowired
	ProductDao productDao;
	@Autowired
	ProductImageDao productImageDao;
	@Autowired
	DisplayInfoImageDao displayInfoImageDao;
	@Autowired
	ProductPriceDao productPriceDao;
	@Autowired
	CommentDao commentDao;
	@Autowired
	CommentImageDao commentImageDao;
	@Autowired
	FileInfoDao fileInfoDao;

	@Override
	public ProductDto getDisplayInfo(Integer displayId) {
		return productDao.selectDisplayInfo(displayId);
	}

	@Override
	@Transactional
	public List<ProductImageDto> getProductImageInfoList(Integer displayId) {
		int productId = productDao.getProductId(displayId);
		return productImageDao.selectAll(productId);

	}

	@Override
	@Transactional
	public List<DisplayInfoImageDto> getDisplayInfoImageList(Integer displayId) {
		return displayInfoImageDao.selectAll(displayId);
	}

	@Override
	@Transactional
	public List<ProductPriceDto> getProductPriceList(Integer displayId) {
		int productId = productDao.getProductId(displayId);
		return productPriceDao.selectAll(productId);
	}

	@Override
	public int getAvgScore(Integer displayId) {
//		List<Integer> scoreList = productDao.selectDisplayInfoScore(displayId);
		int result = 0;
//		if (scoreList.size() == 0) {
//
//		} else {
//			for (int i : scoreList) {
//				result += i;
//			}
//			result = (int) result / scoreList.size();
//		}

		return result;
	}

	@Override
	public int getCountComment(Integer productId) {
//		int productId = productDao.getProductId(displayId);
		return commentDao.countCommentByProduct(productId);
	}

//	@Override
//	public List<CommentDto> getCommentList(Integer productId, Integer start) {
////		int productId = productDao.getProductId(displayId);
//		return commentDao.selectAllComments(productId, start, LIMIT);
//	}
//	@Override
//	public Map<String, Object> getComment(Integer commentId, Integer start){
//		Map<String, Object> map = new HashMap<>();
//		map.put("comment", commentDao.selectAllComments(commentId, start, LIMIT));
//		map.put("reservationUserCommentImage", commentImageDao.selectAll(commentId));
//		return map;
//	}
	@Override
	@Transactional
	public List<CommentDto> getCommentList(Integer productId, Integer start) {
		/*
		 * productId 로 commentId list 구한다
		 * for문 돌려서 commentdto 구하기 - 만약 commentid가 image에 존재하면 image배열에 넣기
		 * */
		List<Integer> commentList = commentDao.getCommentId(productId);
		List<CommentDto> list = new ArrayList<>();
//		List<CommentImageDto> images;
		CommentDto comment;
		for(Integer commentId:commentList) {
			comment = commentDao.selectCommentByCommentId(commentId);
			comment.setImage(commentImageDao.selectAll(commentId));
			list.add(comment);
		}
		return list;
	}
	
	public FileInfo getFileInfo(Integer fileId) {
		return fileInfoDao.selectAll(fileId);
	}

}
