package dw.study.lookie.pr_todolist.dto;

import java.sql.Date;

public class TodoDto {

	private Long id;
	private String title;
	private String name;
	private int sequence;
	private String type;
	private String regDate;
	
	//입력 시 사용할 생성자
	public TodoDto(String title, String name, int sequence) { 
		super();
		this.title = title;
		this.name = name;
		this.sequence = sequence;
	}
	//list 출력 시 사용할 생성자
	public TodoDto(Long id, String title, String name, int sequence, String type, String regDate) {
		super();
		this.id = id;
		this.title = title;
		this.name = name;
		this.sequence = sequence;
		this.type = type;
		this.regDate = regDate;
	}
	//업데이트 시 사용할 생성자
	public TodoDto(Long id, String type) {
		super();
		this.id = id;
		this.type = type;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "TodoDto [id=" + id + ", title=" + title + ", name=" + name + ", sequence=" + sequence + ", type=" + type
				+ ", regDate=" + regDate + "]";
	}
	
	
}
