package dw.study.lookie.pr_naver_reservation_api.service;

import dw.study.lookie.pr_naver_reservation_api.service.security.UserDbService;

//회원과 관련된 모든 정보를 처리하는 서비스
//스프링 시큐리티 설정 관련 파일과 회원정보관련된 부분을 분리해야 하기 때문
public interface UserService extends UserDbService {
	public int getUserId(String loginUserId);
}
