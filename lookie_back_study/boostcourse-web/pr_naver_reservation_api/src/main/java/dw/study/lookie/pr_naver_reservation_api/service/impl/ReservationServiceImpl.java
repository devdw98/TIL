package dw.study.lookie.pr_naver_reservation_api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dw.study.lookie.pr_naver_reservation_api.dao.ReservationDao;
import dw.study.lookie.pr_naver_reservation_api.dao.ReservationInfoDao;
import dw.study.lookie.pr_naver_reservation_api.dao.ReservationInfoPriceDao;
import dw.study.lookie.pr_naver_reservation_api.dto.ReservationDto;
import dw.study.lookie.pr_naver_reservation_api.dto.ReservationInfoDto;
import dw.study.lookie.pr_naver_reservation_api.dto.ReservationInfoPriceDto;
import dw.study.lookie.pr_naver_reservation_api.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService{
	@Autowired
	ReservationDao reservationDao;
	@Autowired
	ReservationInfoDao reservationInfoDao;
	@Autowired
	ReservationInfoPriceDao reservationInfoPriceDao;

	@Override
	public ReservationDto enrollReservationInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReservationInfoPriceDto enrollReservationInfoPrice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<ReservationInfoDto> getReservationInfoList(int userId) {
		List<ReservationInfoDto> list = reservationInfoDao.selectReservationInfoList(userId);
		for(ReservationInfoDto dto:list) {
			dto.setSumPrice(reservationInfoPriceDao.sumPrice(dto.getReservationInfo().getId()));
		}
		return list;
	}

	@Override
	public int getReservationInfoCount(int userId) { //size
		int totalCount = reservationInfoDao.selectReservationInfoCount(userId);
		return totalCount;
	}

	@Override
	@Transactional(readOnly=false)
	public String cancelReservation(int userId, int reservationId) {
		String result="";
		int delCount = reservationDao.changeCancelFlag(reservationId);
		if(delCount == 1)
			result = "success";
		else
			result = "fail";
		return result;
	}

	
}