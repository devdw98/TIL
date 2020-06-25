package dw.study.lookie.pr_naver_reservation_api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dw.study.lookie.pr_naver_reservation_api.dao.UserDao;
import dw.study.lookie.pr_naver_reservation_api.dao.UserRoleDao;
import dw.study.lookie.pr_naver_reservation_api.dto.User;
import dw.study.lookie.pr_naver_reservation_api.dto.UserRole;
import dw.study.lookie.pr_naver_reservation_api.service.UserService;
import dw.study.lookie.pr_naver_reservation_api.service.security.UserEntity;
import dw.study.lookie.pr_naver_reservation_api.service.security.UserRoleEntity;

//UserService 구현 == UserDbService도 포함해서 구현해야한다는 뜻!
@Service
public class UserServiceImpl implements UserService{
	//생성자에 의해 주입되는 객체, 해당 객체를 초기화할 필요가 이후에 없기 때문에 final로 선언함
	// final로 선언하고 초기화를 안한 필드는 생성자에서 초기화 해준다
	private final UserDao userDao;
	private final UserRoleDao userRoleDao;
	
	public UserServiceImpl(UserDao userDao, UserRoleDao userRoleDao) {
		this.userDao = userDao;
		this.userRoleDao = userRoleDao;
	}
	
	
	@Override
	@Transactional //db에서 읽어오니까 설정함
	public UserEntity getUser(String loginUserId) {
		User user = userDao.getUserByEmail(loginUserId);
		return new UserEntity(user.getEmail(), user.getPassword()); //로그인 정보 저장
	}

	@Override
	@Transactional
	public List<UserRoleEntity> getUserRoles(String loginUserId) {
		List<UserRole> userRoles = userRoleDao.getRolesByEmail(loginUserId);
		List<UserRoleEntity> list = new ArrayList<UserRoleEntity>();
		
		for(UserRole role : userRoles) {
			list.add(new UserRoleEntity(loginUserId, role.getRoleName()));
		}
		return list;
	}

	@Override
	@Transactional
	public int getUserId(String loginUserId) {
		User user = userDao.getUserByEmail(loginUserId);
		return user.getId();
	}
}
