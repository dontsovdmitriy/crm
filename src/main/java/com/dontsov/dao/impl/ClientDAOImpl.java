package com.dontsov.dao.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dontsov.dao.ClientDAO;
import com.dontsov.model.entity.*;
import com.dontsov.model.report.UserClientsReport;

@Repository
public class ClientDAOImpl implements ClientDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Client> getClients() {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Client> theQuery = 
				currentSession.createQuery("FROM Client ORDER BY name", 
						Client.class);

		List<Client> clients = theQuery.getResultList();

		return clients;
	}

	@Override
	public void saveClient(Client theClient) {
		Session currentSession= sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(theClient);				
	}

	@Override
	public Client getClient(int theId) {
		Session currentSession= sessionFactory.getCurrentSession();

		Client theClient = currentSession.get(Client.class, theId);

		Hibernate.initialize(theClient.getUser());

		return theClient;
	}

	@Override
	public void deleteClient(int theId) {
		Session currentSession= sessionFactory.getCurrentSession();

		Query theQuery =
				currentSession.createQuery("DELETE FROM Client WHERE id=:clientId");
		theQuery.setParameter("clientId", theId);

		theQuery.executeUpdate();			
	}

	@Override
	public List<Client> userClientsReport(UserClientsReport userClientsReport) {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Client> theQuery =
				currentSession.createQuery("FROM Client WHERE user_id=:userId", Client.class);
		theQuery.setParameter("userId", userClientsReport.getUserId());

		List<Client> clients = theQuery.getResultList();

		return clients;
	}

}
