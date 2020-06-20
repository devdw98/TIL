package dw.study.lookie.w5_securityexam.service.security;

public class UserRoleEntity {
	//로그인 아이디와 권한 정보
	private String loginUserId;
	private String roleName;
	
	public UserRoleEntity(String loginUserId, String roleName) {
		this.loginUserId = loginUserId;
		this.roleName = roleName;
	}
	public String getUserLoginId() {
		return loginUserId;
	}
	public void setUserLoginId(String loginUserId) {
		this.loginUserId = loginUserId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
}
