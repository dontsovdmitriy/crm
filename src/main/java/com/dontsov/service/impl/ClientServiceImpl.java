package com.dontsov.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dontsov.dao.ClientDAO;

import com.dontsov.model.entity.*;
import com.dontsov.model.report.UserClientsReport;
import com.dontsov.service.ClientService;


@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientDAO clientDAO;
	
	@Override
	@Transactional
	public List<Client> getClients() {
		return clientDAO.getClients();

	}

	@Override
	@Transactional
	public void saveClient(Client theClient) {
		clientDAO.saveClient(theClient);
		
	}

	@Override
	@Transactional
	public Client getClient(int theId) {
		return clientDAO.getClient(theId);

	}

	@Override
	@Transactional
	public void deleteClient(int theId) {
		clientDAO.deleteClient(theId);		
		
	}

	@Override
	@Transactional
	public List<Client> userClientsReport(UserClientsReport userClientsReport) {
		return clientDAO.userClientsReport(userClientsReport);
	}

}
