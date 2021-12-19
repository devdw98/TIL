package dw.study.lookie.w5_securityexam.service;

import dw.study.lookie.w5_securityexam.dto.Member;
import dw.study.lookie.w5_securityexam.service.security.UserDbService;

public interface MemberService extends UserDbService{

	Member getMemberByEmail(String loginUserId);
	//회원과 관련된 모든 정보 처리하는 서비스
	// ex) 회원 등록
}
