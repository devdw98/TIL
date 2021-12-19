package dw.study.lookie.pr_todo.dto;

public class TodoDto {
	
	private Long id;
	private String title;
	private String name;
	private int sequence;
	private String type;
	private String regDate;
	
	public TodoDto(){
		
	}
	public TodoDto(Long id, String type) {
		this.id = id;
		this.type = type;
	}
	public TodoDto(String title, String name, int sequence) {
		this.title = title;
		this.name = name;
		this.sequence = sequence;
	}
	public TodoDto(String title, String name, int sequence, String type) {
		this.title = title;
		this.name = name;
		this.sequence = sequence;
		this.type = type;
	}
	
	public TodoDto(Long id, String title, String name, int sequence, String type, String regDate){
		this.id = id;
		this.title = title;
		this.name = name;
		this.sequence = sequence;
		this.type = type;
		this.regDate = regDate;
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
