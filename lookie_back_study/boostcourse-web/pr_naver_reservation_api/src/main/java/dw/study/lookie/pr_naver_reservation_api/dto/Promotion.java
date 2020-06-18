package dw.study.lookie.pr_naver_reservation_api.dto;

public class Promotion {

	private int id; //promotion
	private int productId; //promotion
	private int categoryId; //product
	private String categoryName; //category
	private String description; //product
	private int fileId; //file_info 의 th타입 인 것의 id
	
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
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	@Override
	public String toString() {
		return "Promotion [id=" + id + ", productId=" + productId + ", categoryId=" + categoryId + ", categoryName="
				+ categoryName + ", description=" + description + ", fileId=" + fileId + "]";
	}
	
	
}
