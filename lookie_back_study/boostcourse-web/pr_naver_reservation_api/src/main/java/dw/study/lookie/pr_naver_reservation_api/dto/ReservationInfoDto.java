package dw.study.lookie.pr_naver_reservation_api.dto;

import dw.study.lookie.pr_naver_reservation_api.vo.ReservationInfo;

public class ReservationInfoDto {
	private ReservationInfo reservationInfo;
	private String description;
	private String content;
	private int sumPrice;

	public ReservationInfo getReservationInfo() {
		return reservationInfo;
	}

	public void setReservationInfo(ReservationInfo reservationInfo) {
		this.reservationInfo = reservationInfo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(int sumPrice) {
		this.sumPrice = sumPrice;
	}

}
