package com.dontsov.dao;

import java.util.List;

import com.dontsov.model.entity.*;
import com.dontsov.model.report.ActionClientReport;


public interface ActionDAO {

	public List<Action> getActions();

	public void saveAction(Action theAction);

	public Action getAction(int theId);

	public void deleteAction(int theId);
	
	public List<Action> clientReport(ActionClientReport actionClientReport);
}
