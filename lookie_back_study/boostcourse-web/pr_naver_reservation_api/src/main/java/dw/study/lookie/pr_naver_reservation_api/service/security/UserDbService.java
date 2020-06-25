package dw.study.lookie.pr_naver_reservation_api.service.security;

import java.util.List;

//스프링 시큐리티에서 필요로 하는 정보를 가지고 오는 메소드
public interface UserDbService { 
	
	public UserEntity getUser(String loginUserId);

	public List<UserRoleEntity> getUserRoles(String loginUserId);
}
