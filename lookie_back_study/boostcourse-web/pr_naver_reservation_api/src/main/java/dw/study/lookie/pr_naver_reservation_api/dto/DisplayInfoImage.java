package dw.study.lookie.pr_naver_reservation_api.dto;

public class DisplayInfoImage extends Image{
	// displayInfoImage
		private int displayInfoId; // display_info

		public int getDisplayInfoId() {
			return displayInfoId;
		}

		public void setDisplayInfoId(int displayInfoId) {
			this.displayInfoId = displayInfoId;
		}

		@Override
		public String toString() {
			return "DisplayInfoImage [displayInfoId=" + displayInfoId + "]";
		}
		
}
