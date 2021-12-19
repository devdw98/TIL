package dw.study.lookie.pr_naver_reservation_api.dto;

import dw.study.lookie.pr_naver_reservation_api.vo.Category;
import dw.study.lookie.pr_naver_reservation_api.vo.ProductImage;
import dw.study.lookie.pr_naver_reservation_api.vo.Promotion;

public class PromotionDto{

	private Promotion promotion;
	private Category category;
	private String description; // product;
//	private ProductImage image;
	private int fileId;

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	public ProductImage getImage() {
//		return image;
//	}
//
//	public void setImage(ProductImage image) {
//		this.image = image;
//	}
}
