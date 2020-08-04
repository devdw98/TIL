package kr.or.connect.roleapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.connect.roleapp.dto.Role;

public interface RoleService {
	public List<Role> getRoles();

}
