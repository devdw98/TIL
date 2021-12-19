package dw.study.lookie.pr_naver_reservation_api.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import dw.study.lookie.pr_naver_reservation_api.vo.ReservationInfo;
import dw.study.lookie.pr_naver_reservation_api.vo.ReservationInfoPrice;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReservationDto {

	private ReservationInfo reservationInfo;
	private List<ReservationInfoPrice> prices;

	public List<ReservationInfoPrice> getPrices() {
		return prices;
	}

	public void setPrices(List<ReservationInfoPrice> prices) {
		this.prices = prices;
	}

	public ReservationInfo getReservationInfo() {
		return reservationInfo;
	}

	public void setReservationInfo(ReservationInfo reservationInfo) {
		this.reservationInfo = reservationInfo;
	}

}
