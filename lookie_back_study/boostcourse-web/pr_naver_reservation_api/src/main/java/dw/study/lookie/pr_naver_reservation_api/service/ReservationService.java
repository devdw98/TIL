package dw.study.lookie.pr_naver_reservation_api.service;

import java.util.List;

import dw.study.lookie.pr_naver_reservation_api.dto.ReservationDto;
import dw.study.lookie.pr_naver_reservation_api.dto.ReservationInfoDto;
import dw.study.lookie.pr_naver_reservation_api.dto.ReservationInfoPriceDto;

public interface ReservationService {
	public ReservationDto enrollReservationInfo();

	public ReservationInfoPriceDto enrollReservationInfoPrice();

	public List<ReservationInfoDto> getReservationInfoList(int userId);

	public int getReservationInfoCount(int userId);

	public String cancelReservation(int userId, int reservationId);
}