package com.dontsov.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dontsov.dao.TargetDAO;
import com.dontsov.model.entity.Target;
import com.dontsov.service.TargetService;

@Service
public class TargetServiceImpl implements TargetService {

	@Autowired
	private TargetDAO targetDAO;
	
	@Override
	@Transactional
	public List<Target> getTargets() {
		return targetDAO.getTargets();
	}

	@Override
	@Transactional
	public void saveTarget(Target theTarget) {
		targetDAO.saveTarget(theTarget);
	}

	@Override
	@Transactional
	public Target getTarget(int theId) {
		return targetDAO.getTarget(theId);
	}

	@Override
	@Transactional
	public void deleteTarget(int theId) {
		targetDAO.deleteTarget(theId);

	}

}
