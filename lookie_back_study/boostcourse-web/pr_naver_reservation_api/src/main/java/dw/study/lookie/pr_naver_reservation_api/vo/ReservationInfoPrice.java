package dw.study.lookie.pr_naver_reservation_api.vo;

public class ReservationInfoPrice {
	private int id;
	private int reservationInfoId;
	private int productPriceId;
	private int count;

	@Override
	public String toString() {
		return "ReservationInfoPrice [id=" + id + ", reservationInfoId=" + reservationInfoId + ", productPriceId="
				+ productPriceId + ", count=" + count + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getReservationInfoId() {
		return reservationInfoId;
	}

	public void setReservationInfoId(int reservationInfoId) {
		this.reservationInfoId = reservationInfoId;
	}

	public int getProductPriceId() {
		return productPriceId;
	}

	public void setProductPriceId(int productPriceId) {
		this.productPriceId = productPriceId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
