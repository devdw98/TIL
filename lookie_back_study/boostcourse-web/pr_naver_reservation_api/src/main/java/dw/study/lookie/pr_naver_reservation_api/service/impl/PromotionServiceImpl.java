package dw.study.lookie.pr_naver_reservation_api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dw.study.lookie.pr_naver_reservation_api.dao.PromotionDao;
import dw.study.lookie.pr_naver_reservation_api.dto.Promotion;
import dw.study.lookie.pr_naver_reservation_api.service.PromotionService;

@Service
public class PromotionServiceImpl implements PromotionService{

	@Autowired
	PromotionDao pDao;
	
	@Override
	public int getCount() {
		return pDao.selectCount();
	}

	@Override
	@Transactional
	public List<Promotion> getPromotionList() {
		return pDao.selectAll();
	}

}
