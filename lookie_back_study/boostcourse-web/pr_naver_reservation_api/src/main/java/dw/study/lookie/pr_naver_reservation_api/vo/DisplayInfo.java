package dw.study.lookie.pr_naver_reservation_api.vo;

public class DisplayInfo extends Product {

	private int displayInfoId;
	private int productId;
	private String openingHours;
	private String placeName;
	private String placeLot;
	private String placeStreet;
	private String tel;
	private String homepage;
	private String email;
//	private DateInfo dateInfo;

	public int getDisplayInfoId() {
		return displayInfoId;
	}

	public void setDisplayInfoId(int id) {
		this.displayInfoId = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getOpeningHours() {
		return openingHours;
	}

	public void setOpeningHours(String openingHours) {
		this.openingHours = openingHours;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getPlaceLot() {
		return placeLot;
	}

	public void setPlaceLot(String placeLot) {
		this.placeLot = placeLot;
	}

	public String getPlaceStreet() {
		return placeStreet;
	}

	public void setPlaceStreet(String placeStreet) {
		this.placeStreet = placeStreet;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	public DateInfo getDateInfo() {
//		return dateInfo;
//	}
//
//	public void setDateInfo(DateInfo dateInfo) {
//		this.dateInfo = dateInfo;
//	}

	@Override
	public String toString() {
		return "DisplayInfo [id=" + displayInfoId + ", productId=" + productId + ", openingHours=" + openingHours
				+ ", placeName=" + placeName + ", placeLot=" + placeLot + ", placeStreet=" + placeStreet + ", tel="
				+ tel + ", homepage=" + homepage + ", email=" + email + "]";
	}

}
