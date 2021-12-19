package dw.study.lookie.pr_naver_reservation_api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dw.study.lookie.pr_naver_reservation_api.dao.ReservationDao;
import dw.study.lookie.pr_naver_reservation_api.dao.ReservationInfoDao;
import dw.study.lookie.pr_naver_reservation_api.dao.ReservationInfoPriceDao;
import dw.study.lookie.pr_naver_reservation_api.dto.ReservationInfoDto;
import dw.study.lookie.pr_naver_reservation_api.dto.ReservationInfoPriceDto;
import dw.study.lookie.pr_naver_reservation_api.service.ReservationService;
import dw.study.lookie.pr_naver_reservation_api.vo.ReservationInfoPrice;

@Service
public class ReservationServiceImpl implements ReservationService {
	@Autowired
	ReservationDao reservationDao;
	@Autowired
	ReservationInfoDao reservationInfoDao;
	@Autowired
	ReservationInfoPriceDao reservationInfoPriceDao;

	@Override
	@Transactional
	public ReservationInfoDto enrollReservationInfo(ReservationInfoDto reservationInfo) {
		int insertInfo = reservationInfoDao.insertReservationInfo(reservationInfo);
		int insertPrices = 0;
		List<ReservationInfoPrice> prices = reservationInfo.getPrices();
		System.out.println(insertInfo);
		if (insertInfo == 1) {
			for (ReservationInfoPrice price : prices) {
				price.setReservationInfoId(reservationInfo.getId());
				insertPrices += reservationInfoPriceDao.insertReservationInfoPrice(price);
			}

		}

		if (insertInfo == 1 && insertPrices == prices.size()) {
			ReservationInfoDto dto = reservationInfoDao.selectReservation(reservationInfo.getId());
			dto.setPrices(reservationInfoPriceDao.selectReservationInfoPrices(dto.getId()));
			return dto;
		} else {
			return null;
		}
	}

	@Override
	@Transactional
	public List<ReservationInfoDto> getReservationInfoList(int userId) {
		List<ReservationInfoDto> list = reservationInfoDao.selectReservationInfoList(userId);
		for (ReservationInfoDto dto : list) {
			dto.setSumPrice(reservationInfoPriceDao.sumPrice(dto.getId()));
		}
		return list;
	}

	@Override
	public int getReservationInfoCount(int userId) { // size
		int totalCount = reservationInfoDao.selectReservationInfoCount(userId);
		return totalCount;
	}

	@Override
	@Transactional(readOnly = false)
	public String cancelReservation(int userId, int reservationId) {
		String result = "";
		
		int delCount = reservationInfoDao.changeCancelFlag(userId, reservationId);
		delCount += reservationInfoDao.changeModifyDate(userId, reservationId);
		System.out.println(delCount);
		if (delCount == 2)
			result = "success";
		else
			result = "fail";
		return result;
	}

}