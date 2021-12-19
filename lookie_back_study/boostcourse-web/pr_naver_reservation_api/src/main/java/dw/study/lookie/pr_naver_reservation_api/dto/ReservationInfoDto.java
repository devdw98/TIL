package dw.study.lookie.pr_naver_reservation_api.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import dw.study.lookie.pr_naver_reservation_api.vo.DateInfo;
import dw.study.lookie.pr_naver_reservation_api.vo.ReservationInfo;
import dw.study.lookie.pr_naver_reservation_api.vo.ReservationInfoPrice;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReservationInfoDto extends ReservationInfo{
//	private ReservationInfo reservationInfo;
	private int id;
	private int productId;
	private int displayInfoId;
	private int userId;
	private Date reservationDate;
	private int cancelFlag;
	private DateInfo dateInfo;
	
	private String description;
	private String content;
	private int sumPrice;
	private List<ReservationInfoPrice> prices;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getDisplayInfoId() {
		return displayInfoId;
	}

	public void setDisplayInfoId(int displayInfoId) {
		this.displayInfoId = displayInfoId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	public int getCancelFlag() {
		return cancelFlag;
	}

	public void setCancelFlag(int cancelFlag) {
		this.cancelFlag = cancelFlag;
	}

	public DateInfo getDateInfo() {
		return dateInfo;
	}

	public void setDateInfo(DateInfo dateInfo) {
		this.dateInfo = dateInfo;
	}


//	public List<ReservationInfoPriceDto> getPrices() {
//		return prices;
//	}
//
//	public void setPrices(List<ReservationInfoPriceDto> prices) {
//		this.prices = prices;
//	}

//	public ReservationInfo getReservationInfo() {
//		return reservationInfo;
//	}
//
//	public void setReservationInfo(ReservationInfo reservationInfo) {
//		this.reservationInfo = reservationInfo;
//	}

	public List<ReservationInfoPrice> getPrices() {
		return prices;
	}

	public void setPrices(List<ReservationInfoPrice> prices) {
		this.prices = prices;
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
