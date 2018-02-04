package com.dontsov.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dontsov.dao.RoleDAO;
import com.dontsov.model.entity.Role;
import com.dontsov.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDAO roleDAO;
		
	@Transactional
	@Override
	public List<Role> getRoles() {
		return roleDAO.getRoles();
	}
	
	@Transactional
	@Override
	public void saveRole(Role theRole) {
		roleDAO.saveRole(theRole);
	}

	@Transactional
	@Override
	public Role getRole(int theId) {
		return roleDAO.getRole(theId);

	}

	@Transactional
	@Override
	public void deleteRole(int theId) {
		roleDAO.deleteRole(theId);
		
	}

}
