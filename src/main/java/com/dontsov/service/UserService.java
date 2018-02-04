package com.dontsov.service;

import java.util.List;
import java.util.Set;

import com.dontsov.model.entity.*;
import com.dontsov.model.report.UserRoles;

public interface UserService {

	public List<User> getUsers();

	public void updateUser(User theUser);

	public User getUser(int theId);

	public void deleteUser(int theId);
	
    public User findByUsername(String username);

	public Set<Role> getUserRoles(UserRoles userRoles);

	public void deleteUserRole(int roleId, int userId);

	public void addRoleForUser(UserRoles userRoles);
	
	public void registration(User theUser);

	public void saveUser(User theUser);


}
