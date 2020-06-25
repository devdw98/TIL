package dw.study.lookie.pr_naver_reservation_api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import dw.study.lookie.pr_naver_reservation_api.vo.DisplayInfo;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto extends DisplayInfo {

//	private Product product;
	private String name; // category
	private DisplayInfo displayInfo;
	private int fileId; // fileId

//	public Product getProduct() {
//		return product;
//	}
//
//	public void setProduct(Product product) {
//		this.product = product;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DisplayInfo getDisplayInfo() {
		return displayInfo;
	}

	public void setDisplayInfo(DisplayInfo displayInfo) {
		this.displayInfo = displayInfo;
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

}
