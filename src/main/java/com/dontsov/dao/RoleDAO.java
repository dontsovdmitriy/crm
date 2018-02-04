package com.dontsov.dao;

import java.util.List;

import com.dontsov.model.entity.Role;

public interface RoleDAO {

	public List<Role> getRoles();

	public void saveRole(Role theRole);

	public Role getRole(int theId);

	public void deleteRole(int theId);
}
