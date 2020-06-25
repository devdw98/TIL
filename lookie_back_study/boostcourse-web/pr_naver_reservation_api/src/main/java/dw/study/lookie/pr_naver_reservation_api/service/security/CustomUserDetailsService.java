package dw.study.lookie.pr_naver_reservation_api.service.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserDbService userdbService; //db에서 로그인 아이디에 해당하는 정보를 읽기위해 객체를 주입받음

	@Override
	public UserDetails loadUserByUsername(String loginUserId) throws UsernameNotFoundException {
		// loginUserId에 해당하는 정보를 db에서 읽어 customUser 객체에 저장 -> CustomUserDetails 에 저장
		UserEntity customUser = userdbService.getUser(loginUserId);
		if (customUser == null)
			throw new UsernameNotFoundException("해당 아이디의 사용자를 찾을 수 없습니다.");

		CustomUserDetails customUserDetails = new CustomUserDetails(); //db에서 읽은 사용자 정보들 저장하는 객체
		customUserDetails.setUsername(customUser.getLoginUserId());
		customUserDetails.setPassword(customUser.getPassword());
		
		//로그인한 사용자의 권한 읽어옴
		List<UserRoleEntity> customUserRoles = userdbService.getUserRoles(loginUserId);

		List<GrantedAuthority> authorities = new ArrayList<>();
		if (customUserRoles != null) {
			for (UserRoleEntity entity : customUserRoles) {
				authorities.add(new SimpleGrantedAuthority(entity.getRoleName()));
			}
		}

		customUserDetails.setAuthorities(authorities);
		customUserDetails.setEnabled(true);
		customUserDetails.setAccountNonExpired(true);
		customUserDetails.setAccountNonLocked(true);
		customUserDetails.setCredentialsNonExpired(true);

		return customUserDetails;
	}

}
