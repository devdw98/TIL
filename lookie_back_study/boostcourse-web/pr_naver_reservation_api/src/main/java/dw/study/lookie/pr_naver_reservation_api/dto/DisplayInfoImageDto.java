package dw.study.lookie.pr_naver_reservation_api.dto;

import dw.study.lookie.pr_naver_reservation_api.vo.DisplayInfoImage;
import dw.study.lookie.pr_naver_reservation_api.vo.FileInfo;

public class DisplayInfoImageDto {
	private DisplayInfoImage image;
	private FileInfo fileInfo;

	public DisplayInfoImage getImage() {
		return image;
	}

	public void setImage(DisplayInfoImage image) {
		this.image = image;
	}

	public FileInfo getFileInfo() {
		return fileInfo;
	}

	public void setFileInfo(FileInfo fileInfo) {
		this.fileInfo = fileInfo;
	}

}
