package com.dontsov.dao;

import java.util.List;

import com.dontsov.model.entity.Client;
import com.dontsov.model.report.UserClientsReport;


public interface ClientDAO {

	public List<Client> getClients();

	public void saveClient(Client theClient);

	public Client getClient(int theId);

	public void deleteClient(int theId);
	
	public List<Client> userClientsReport(UserClientsReport userClientsReport);

}
