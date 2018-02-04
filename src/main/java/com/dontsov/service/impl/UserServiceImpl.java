package com.dontsov.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dontsov.dao.RoleDAO;
import com.dontsov.dao.UserDAO;
import com.dontsov.model.entity.*;
import com.dontsov.model.report.UserRoles;
import com.dontsov.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private RoleDAO roleDAO;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	@Transactional
	public List<User> getUsers() {
		return userDAO.getUsers();
	}

	@Override
	@Transactional
	public void updateUser(User theUser) {
		userDAO.updateUser(theUser);
	}

	@Override
	@Transactional
	public User getUser(int theId) {
		return userDAO.getUser(theId);
	}

	@Override
	@Transactional
	public void deleteUser(int theId) {
		userDAO.deleteUser(theId);		
	}

	@Override
	@Transactional
	public User findByUsername(String username) {
		return userDAO.findByUsername(username);
	}

	@Override
	@Transactional
	public Set<Role> getUserRoles(UserRoles userRoles) {
		return userDAO.getUserRoles(userRoles);

	}

	@Override
	@Transactional
	public void deleteUserRole(int roleId, int userId) {
		User user = userDAO.getUser(userId);
		Role role = roleDAO.getRole(roleId);
		userDAO.deleteUserRole(role, user);		
		
	}

	@Override
	@Transactional
	public void addRoleForUser(UserRoles userRoles) {
		User user = userDAO.getUser(userRoles.getUserId());
		Role role = roleDAO.getRole(userRoles.getRoleId());
		userDAO.addRoleForUser(user, role);
	}

	@Override
	@Transactional
	public void registration(User theUser) {
		theUser.setPassword(bCryptPasswordEncoder.encode(theUser.getPassword()));
		Set<Role> roles = new HashSet<>();
		roles.add(roleDAO.getRole(1));
		theUser.setRoles(roles);
		userDAO.saveUser(theUser);		
	}

	@Override
	public void saveUser(User theUser) {
		// TODO Auto-generated method stub
		
	}

}
