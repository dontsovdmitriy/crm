package com.dontsov.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dontsov.dao.*;
import com.dontsov.model.entity.*;
import com.dontsov.model.report.ActionClientReport;

@Repository
public class ActionDAOImpl implements ActionDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Action> getActions() {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Action> theQuery = 
				currentSession.createQuery("FROM Action ORDER BY date_time", 
						Action.class);

		List<Action> actions = theQuery.getResultList();

		return actions;
	}

	@Override
	public void saveAction(Action theAction) {
		Session currentSession= sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(theAction);			
	}

	@Override
	public Action getAction(int theId) {
		Session currentSession= sessionFactory.getCurrentSession();

		Action theAction = currentSession.get(Action.class, theId);

		return theAction;
	}

	@Override
	public void deleteAction(int theId) {
		Session currentSession= sessionFactory.getCurrentSession();
		
		
		Query theQuery =
				currentSession.createQuery("DELETE FROM Action WHERE id=:actionId");
		theQuery.setParameter("actionId", theId);

		theQuery.executeUpdate();			
	}

	@Override
	public List<Action> clientReport(ActionClientReport actionClientReport) {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Action> theQuery =
				currentSession.createQuery("FROM Action WHERE client_id=:clientId AND date_time between :dateFrom AND :dateTo", Action.class);
		theQuery.setParameter("clientId", actionClientReport.getClientId());
		theQuery.setParameter("dateFrom", actionClientReport.getDateFrom());
		theQuery.setParameter("dateTo", actionClientReport.getDateTo());

		List<Action> actions = theQuery.getResultList();

		return actions;
	}

}
