package dw.study.lookie.w5_securityexam.service.security;

public class UserEntity {
	//로그인 아이디와 암호 정보
	
	private String loginUserId;
	private String password;
	
	public UserEntity(String loginUserId, String password) {
		this.loginUserId = loginUserId;
		this.password = password;
	}
	public String getLoginUserId() {
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
