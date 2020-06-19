package dw.study.lookie.pr_naver_reservation_api.dto;

public class ProductImage extends Image{

		private int productId; // product_image
		private int productImageId; // product_image
		private String type; // product_image
		public int getProductId() {
			return productId;
		}
		public void setProductId(int productId) {
			this.productId = productId;
		}
		public int getProductImageId() {
			return productImageId;
		}
		public void setProductImageId(int productImageId) {
			this.productImageId = productImageId;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		@Override
		public String toString() {
			return "ProductImage [productId=" + productId + ", productImageId=" + productImageId + ", type=" + type
					+ "]";
		}
		
}
