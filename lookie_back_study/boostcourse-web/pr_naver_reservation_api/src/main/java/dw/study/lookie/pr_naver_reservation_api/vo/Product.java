package dw.study.lookie.pr_naver_reservation_api.vo;

public class Product extends DateInfo {
//	public Product(Date date, Date date2) {
//		super(date, date2);
//		// TODO Auto-generated constructor stub
//	}

	private int id;
	private int categoryId;
	private String description;
	private String content;
	private String event;
	private DateInfo dateInfo;

	@Override
	public String toString() {
		return "Product [id=" + id + ", categoryId=" + categoryId + ", description=" + description + ", content="
				+ content + ", event=" + event + ", dateInfo=" + dateInfo + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public DateInfo getDateInfo() {
		return dateInfo;
	}

	public void setDateInfo(DateInfo dateInfo) {
		this.dateInfo = dateInfo;
	}

}
