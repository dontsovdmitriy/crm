package com.dontsov.dao.impl;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dontsov.dao.UserDAO;
import com.dontsov.model.entity.*;
import com.dontsov.model.report.UserRoles;

@Repository
public class UserDAOImpl implements UserDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<User> getUsers() {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<User> theQuery = 
				currentSession.createQuery("FROM User ORDER BY surname", 
						User.class);

		List<User> users = theQuery.getResultList();

		return users;
	}

	@Override
	public void saveUser(User theUser) {

		Session currentSession= sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(theUser);				
	}

	@Override
	public User getUser(int theId) {
		Session currentSession= sessionFactory.getCurrentSession();

		User theUser = currentSession.get(User.class, theId);

		return theUser;
	}

	@Override
	public void deleteUser(int theId) {
		Session currentSession= sessionFactory.getCurrentSession();

		Query theQuery =
				currentSession.createQuery("DELETE FROM User WHERE id=:userId");
		theQuery.setParameter("userId", theId);

		theQuery.executeUpdate();			
	}

	@Override
	public User findByUsername(String username) {
		Session currentSession= sessionFactory.getCurrentSession();

		Query theQuery =
				currentSession.createQuery("FROM User WHERE username=:username");
		theQuery.setParameter("username", username);

		User theUser = (User)theQuery.uniqueResult();

		return theUser;
	}

	@Override
	public Set<Role> getUserRoles(UserRoles userRoles) {
		Session currentSession = sessionFactory.getCurrentSession();

		User theUser = currentSession.get(User.class, userRoles.getUserId());

		Set<Role> roles = theUser.getRoles();

		return roles;
	}

	@Override
	public void deleteUserRole(Role role, User user) {
		
		role.getUsers().remove(user);
		user.getRoles().remove(role);

	}

	@Override
	public void addRoleForUser(User user, Role role) {
		Set<Role> userRoles = user.getRoles();
		userRoles.add(role);

	}

	@Override
	public void updateUser(User theUser) {
		
		Session currentSession = sessionFactory.getCurrentSession();

		Query query = currentSession.createQuery("UPDATE User SET surname = :surname, name = :name, second_name = :secondName, phone_number = :phoneNumber" +
				" where id = :id");
		query.setParameter("surname", theUser.getSurname());
		query.setParameter("name", theUser.getName());
		query.setParameter("secondName", theUser.getSecondName());
		query.setParameter("phoneNumber", theUser.getPhoneNumber());
		query.setParameter("id", theUser.getId());

		int result = query.executeUpdate();
	}

}
