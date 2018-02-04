package com.dontsov.dao;

import java.util.List;
import java.util.Set;

import com.dontsov.model.entity.*;
import com.dontsov.model.report.UserRoles;


public interface UserDAO {

	public List<User> getUsers();

	public void saveUser(User theUser);

	public User getUser(int theId);

	public void deleteUser(int theId);
	
	public User findByUsername(String username);

	public Set<Role> getUserRoles(UserRoles userRoles);

	public void deleteUserRole(Role role, User user);

	public void addRoleForUser(User user, Role role);

	public void updateUser(User theUser);

}
