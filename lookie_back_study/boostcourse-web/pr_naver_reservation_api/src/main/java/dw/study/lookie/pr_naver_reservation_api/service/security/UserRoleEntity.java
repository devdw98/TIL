package dw.study.lookie.pr_naver_reservation_api.service.security;

//로그인 아이디와 권한 정보를 가지는 객체
public class UserRoleEntity {
	private String loginUserId;
	private String roleName;

	public UserRoleEntity(String loginUserId, String roleName) {
		this.loginUserId = loginUserId;
		this.roleName = roleName;
	}

	public String getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
