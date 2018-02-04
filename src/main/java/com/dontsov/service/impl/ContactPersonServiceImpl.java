package com.dontsov.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dontsov.dao.ContactPersonDAO;
import com.dontsov.model.entity.*;
import com.dontsov.model.report.ClientContactReport;
import com.dontsov.service.ContactPersonService;

@Service
public class ContactPersonServiceImpl implements ContactPersonService {

	@Autowired
	private ContactPersonDAO contactPersonDAO;
	
	
	@Override
	@Transactional
	public List<ContactPerson> getContactPersons() {
		return contactPersonDAO.getContactPersons();
	}

	@Override
	@Transactional
	public void saveContactPerson(ContactPerson theContactPerson) {
		contactPersonDAO.saveContactPerson(theContactPerson);		
	}

	@Override
	@Transactional
	public ContactPerson getContactPerson(int theId) {
		return contactPersonDAO.getContactPerson(theId);
	}

	@Override
	@Transactional
	public void deleteContactPerson(int theId) {
		contactPersonDAO.deleteContactPerson(theId);		
		
	}

	@Override
	@Transactional
	public List<ContactPerson> clientContacts(ClientContactReport clientContactReport) {
		return contactPersonDAO.clientContacts(clientContactReport);

	}

}
