package dw.study.lookie.pr_naver_reservation_api.vo;

public class FileInfo {
	private int id;
	private String fileName;
	private String saveFileName;
	private String conentType;
	private int deleteFlag;
	private DateInfo dateInfo;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getSaveFileName() {
		return saveFileName;
	}

	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}

	public String getConentType() {
		return conentType;
	}

	public void setConentType(String conentType) {
		this.conentType = conentType;
	}

	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public DateInfo getDateInfo() {
		return dateInfo;
	}

	public void setDateInfo(DateInfo dateInfo) {
		this.dateInfo = dateInfo;
	}

	@Override
	public String toString() {
		return "FileInfo [id=" + id + ", fileName=" + fileName + ", saveFileName=" + saveFileName + ", conentType="
				+ conentType + ", deleteFlag=" + deleteFlag + ", dateInfo=" + dateInfo + "]";
	}

}
