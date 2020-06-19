package dw.study.lookie.pr_naver_reservation_api.dto;

public class ReservationUserCommentImage extends Image{
	//reservationUserCommentImage
		private int reservationInfoId; //reservation_user_comment_image
		private int reservationUserCommentId; //reservation_user_comment_image
		public int getReservationInfoId() {
			return reservationInfoId;
		}
		public void setReservationInfoId(int reservationInfoId) {
			this.reservationInfoId = reservationInfoId;
		}
		public int getReservationUserCommentId() {
			return reservationUserCommentId;
		}
		public void setReservationUserCommentId(int reservationUserCommentId) {
			this.reservationUserCommentId = reservationUserCommentId;
		}
		@Override
		public String toString() {
			return "ReservationUserCommentImage [reservationInfoId=" + reservationInfoId + ", reservationUserCommentId="
					+ reservationUserCommentId + "]";
		}
		
}
