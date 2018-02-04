package com.dontsov.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dontsov.dao.ContactPersonDAO;
import com.dontsov.model.entity.*;
import com.dontsov.model.report.ClientContactReport;

@Repository
public class ContactPersonDAOImpl implements ContactPersonDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<ContactPerson> getContactPersons() {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<ContactPerson> theQuery = 
				currentSession.createQuery("from ContactPerson order by surname", 
						ContactPerson.class);

		List<ContactPerson> contactPersonss = theQuery.getResultList();

		return contactPersonss;
	}

	@Override
	public void saveContactPerson(ContactPerson theContactPerson) {
		Session currentSession= sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(theContactPerson);			
	}

	@Override
	public ContactPerson getContactPerson(int theId) {
		Session currentSession= sessionFactory.getCurrentSession();

		ContactPerson theContactPerson = currentSession.get(ContactPerson.class, theId);

		return theContactPerson;
	}

	@Override
	public void deleteContactPerson(int theId) {
		Session currentSession= sessionFactory.getCurrentSession();

		Query theQuery =
				currentSession.createQuery("delete from ContactPerson where id=:contactPersonId");
		theQuery.setParameter("contactPersonId", theId);

		theQuery.executeUpdate();			
	}

	@Override
	public List<ContactPerson> clientContacts(ClientContactReport clientContactReport) {
		Session currentSession = sessionFactory.getCurrentSession();

				Query<ContactPerson> theQuery =
						currentSession.createQuery("FROM ContactPerson WHERE client_id=:clientId", ContactPerson.class);
				theQuery.setParameter("clientId", clientContactReport.getClientId());
		
				List<ContactPerson> contactPersons = theQuery.getResultList();

				return contactPersons;
	}

}
