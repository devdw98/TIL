package dw.study.lookie.pr_naver_reservation_api.dto;

import dw.study.lookie.pr_naver_reservation_api.vo.FileInfo;
import dw.study.lookie.pr_naver_reservation_api.vo.ReservationUserCommentImage;

public class CommentImageDto {
	private ReservationUserCommentImage image;
	private FileInfo file;

	public FileInfo getFile() {
		return file;
	}

	public void setFile(FileInfo file) {
		this.file = file;
	}

	public ReservationUserCommentImage getImage() {
		return image;
	}

	public void setImage(ReservationUserCommentImage image) {
		this.image = image;
	}

}
