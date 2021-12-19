package dw.study.lookie.w3_diexam01;

//bean class
public class UserBean {
	//field는 반드시 private
	private String name;
	private int age;
	private boolean male;
	//기본생성자 반드시 가지고 있어야 함
	public UserBean() {
		
	}
	
	public UserBean(String name, int age, boolean male) {
		this.name = name;
		this.age = age;
		this.male = male;
	}
	//getter, setter 메소드를 가진다.
	//getName(), setName() 메소드를 name 프로퍼티(property)라고 함.
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isMale() {
		return male;
	}

	public void setMale(boolean male) {
		this.male = male;
	}
	
}
