package dw.study.lookie.w5_securityexam.service.security;

import java.util.List;

public interface UserDbService {
	//스프링 시큐리티에서 필요로 하는 정보를 가지고 오는 메소드
	public UserEntity getUser(String loginUserId);
	public List<UserRoleEntity> getUserRoles(String loginUserId);
	
}
