package dw.study.lookie.pr_naver_reservation_api.dto;

import java.util.Date;

public class ReservationUserComment {
	private int id; //reservation_user_comment
	private int productId; //reservation_user_comment
	private int reservationInfoId; //reservation_user_comment
	private float score; //reservation_user_comment
	private String reservationEmail;
	private String comment; //reservation_user_comment
	private Date createDate; //reservation_user_comment
	private Date modifyDate; //reservation_user_comment
	private Image[] reservationUserCommentImages;
	
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
	public int getReservationInfoId() {
		return reservationInfoId;
	}
	public void setReservationInfoId(int reservationInfoId) {
		this.reservationInfoId = reservationInfoId;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public String getReservationEmail() {
		return reservationEmail;
	}
	public void setReservationEmail(String reservationEmail) {
		this.reservationEmail = reservationEmail;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public Image[] getReservationUserCommentImages() {
		return reservationUserCommentImages;
	}
	public void setReservationUserCommentImages(Image[] reservationUserCommentImages) {
		this.reservationUserCommentImages = reservationUserCommentImages;
	}
	
	
}
