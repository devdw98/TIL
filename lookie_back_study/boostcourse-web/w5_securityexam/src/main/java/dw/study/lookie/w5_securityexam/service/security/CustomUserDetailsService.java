package dw.study.lookie.w5_securityexam.service.security;

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
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	UserDbService userdbService;
	
	@Override
	public UserDetails loadUserByUsername(String loginUserId) throws UsernameNotFoundException {
		//사용자가 로그인 시 아이디 입력하면 해당 아이디를 이 메소드의 인자로 전달 
		// -> 아이디 정보가 없으면 Exception 발생
		// -> 아이디 정보가 있으면 UserDetails 객체 리턴
		UserEntity customUser = userdbService.getUser(loginUserId);
		if(customUser == null) 
			throw new UsernameNotFoundException("사용자가 입력한 아이디에 해당하는 사용자를 찾을 수 없습니다.");
		
		CustomUserDetails customUserDetails = new CustomUserDetails();
		customUserDetails.setUsername(customUser.getLoginUserId());
		customUserDetails.setPassword(customUser.getPassword());
		
		List<UserRoleEntity> customRoles = userdbService.getUserRoles(loginUserId);
		List<GrantedAuthority> authorities = new ArrayList<>();
		if(customRoles != null) {
			for(UserRoleEntity customRole : customRoles) {
				authorities.add(new SimpleGrantedAuthority(customRole.getRoleName()));
			}
		}
		
		//CustomUserDetails 객체에 권한 목록 설정
		customUserDetails.setAuthorities(authorities);
        customUserDetails.setEnabled(true);
        customUserDetails.setAccountNonExpired(true);
        customUserDetails.setAccountNonLocked(true);
        customUserDetails.setCredentialsNonExpired(true);
        return customUserDetails;
	}
	
}
