package dw.study.lookie.pr_naver_reservation_api.vo;

import java.util.Date;

public class DateInfo {

	private Date createDate;
	private Date modifyDate;

//	public DateInfo(java.sql.Date date, java.sql.Date date2) {
//		this.createDate = date;
//		this.modifyDate = date2;
//	}

	@Override
	public String toString() {
		return "DateInfo [createDate=" + createDate + ", modifyDate=" + modifyDate + "]";
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
}
