package dw.study.lookie.pr_naver_reservation_api.dto;

import dw.study.lookie.pr_naver_reservation_api.vo.FileInfo;
import dw.study.lookie.pr_naver_reservation_api.vo.ProductImage;

public class ProductImageDto {
	private ProductImage image;
	private FileInfo fileInfo;

	public ProductImage getImage() {
		return image;
	}

	public void setImage(ProductImage image) {
		this.image = image;
	}

	public FileInfo getFileInfo() {
		return fileInfo;
	}

	public void setFileInfo(FileInfo fileInfo) {
		this.fileInfo = fileInfo;
	}

}
