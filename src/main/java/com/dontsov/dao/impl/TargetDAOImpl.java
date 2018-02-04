package com.dontsov.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dontsov.dao.TargetDAO;
import com.dontsov.model.entity.*;

@Repository
public class TargetDAOImpl implements TargetDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Target> getTargets() {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Target> theQuery = 
				currentSession.createQuery("FROM Target ORDER BY name", 
						Target.class);

		List<Target> targets = theQuery.getResultList();

		return targets;
	}

	@Override
	public void saveTarget(Target theTarget) {

		Session currentSession= sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(theTarget);		
	}

	@Override
	public Target getTarget(int theId) {
		Session currentSession= sessionFactory.getCurrentSession();

		Target theTarget = currentSession.get(Target.class, theId);

		return theTarget;
	}

	@Override
	public void deleteTarget(int theId) {
		Session currentSession= sessionFactory.getCurrentSession();

		Query theQuery =
				currentSession.createQuery("DELETE FROM Target WHERE id=:targetId");
		theQuery.setParameter("targetId", theId);

		theQuery.executeUpdate();		
	}

}
