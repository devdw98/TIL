package dw.study.lookie.pr_naver_reservation_api.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import dw.study.lookie.pr_naver_reservation_api.vo.ReservationUserComment;
import dw.study.lookie.pr_naver_reservation_api.vo.ReservationUserCommentImage;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommentDto {
	private ReservationUserComment comment;
	private List<CommentImageDto> image;

	public List<CommentImageDto> getImage() {
		return image;
	}

	public void setImage(List<CommentImageDto> list) {
		this.image = list;
	}

	public ReservationUserComment getComment() {
		return comment;
	}

	public void setComment(ReservationUserComment comment) {
		this.comment = comment;
	}

}
