package com.dontsov.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dontsov.dao.RoleDAO;
import com.dontsov.model.entity.Role;

@Repository
public class RoleDAOImpl implements RoleDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Role> getRoles() {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Role> theQuery = 
				currentSession.createQuery("FROM Role ORDER BY name", 
						Role.class);

		List<Role> roles = theQuery.getResultList();

		return roles;
	}

	@Override
	public void saveRole(Role theRole) {
		Session currentSession= sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(theRole);		

	}

	@Override
	public Role getRole(int theId) {
		Session currentSession= sessionFactory.getCurrentSession();

		Role theRole = currentSession.get(Role.class, theId);

		return theRole;
	}

	@Override
	public void deleteRole(int theId) {
		Session currentSession= sessionFactory.getCurrentSession();

		Query theQuery =
				currentSession.createQuery("delete from Roles where id=:roleId");
		theQuery.setParameter("roleId", theId);

		theQuery.executeUpdate();
	}

}
