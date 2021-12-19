package kr.or.connect.roleapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.roleapp.dao.RoleDao;
import kr.or.connect.roleapp.dto.Role;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleDao roleDao;

	@Override
	@Transactional(readOnly = true)
	public List<Role> getRoles() {
		return roleDao.selectAll();
	}
}
