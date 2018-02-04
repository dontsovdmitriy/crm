package com.dontsov.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dontsov.dao.ActionDAO;
import com.dontsov.model.entity.*;
import com.dontsov.model.report.ActionClientReport;
import com.dontsov.service.ActionService;

@Service
public class ActionServiceImpl implements ActionService {

	@Autowired
	private ActionDAO actionDAO;
	
	@Override
	@Transactional
	public List<Action> getActions() {
		return actionDAO.getActions();
	}

	@Override
	@Transactional
	public void saveAction(Action theAction) {
		actionDAO.saveAction(theAction);
		
	}

	@Override
	@Transactional
	public Action getAction(int theId) {
		return actionDAO.getAction(theId);

	}

	@Override
	@Transactional
	public void deleteAction(int theId) {
		actionDAO.deleteAction(theId);		
		
	}

	@Override
	@Transactional
	public List<Action> clientReport(ActionClientReport actionClientReport) {
		return actionDAO.clientReport(actionClientReport);
	}

}
