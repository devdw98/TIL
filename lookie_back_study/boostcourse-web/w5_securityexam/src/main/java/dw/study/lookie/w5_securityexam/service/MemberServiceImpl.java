package dw.study.lookie.w5_securityexam.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dw.study.lookie.w5_securityexam.dao.MemberDao;
import dw.study.lookie.w5_securityexam.dao.MemberRoleDao;
import dw.study.lookie.w5_securityexam.dto.Member;
import dw.study.lookie.w5_securityexam.dto.MemberRole;
import dw.study.lookie.w5_securityexam.service.security.UserEntity;
import dw.study.lookie.w5_securityexam.service.security.UserRoleEntity;

@Service
public class MemberServiceImpl implements MemberService{
	
	private final MemberDao memberDao;
	private final MemberRoleDao memberRoleDao;
	
	public MemberServiceImpl(MemberDao memberDao, MemberRoleDao memberRoleDao) {
		this.memberDao = memberDao;
		this.memberRoleDao = memberRoleDao;
	}

    @Override
    @Transactional
    public UserEntity getUser(String loginUserId) {
    	Member member = memberDao.getMemberByEmail(loginUserId);
        return new UserEntity(member.getEmail(), member.getPassword());
    }

    @Override
    @Transactional
    public List<UserRoleEntity> getUserRoles(String loginUserId) {
    	List<MemberRole> memberRoles = memberRoleDao.getRolesByEmail(loginUserId);
        List<UserRoleEntity> list = new ArrayList<>();
        for(MemberRole r : memberRoles) {
        	list.add(new UserRoleEntity(loginUserId, r.getRoleName()));
        }
        
        return list;
    }
	

}
