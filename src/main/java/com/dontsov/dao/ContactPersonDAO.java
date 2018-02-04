package com.dontsov.dao;

import java.util.List;

import com.dontsov.model.entity.ContactPerson;
import com.dontsov.model.report.ClientContactReport;


public interface ContactPersonDAO {

	public List<ContactPerson> getContactPersons();

	public void saveContactPerson(ContactPerson theContactPerson);

	public ContactPerson getContactPerson(int theId);

	public void deleteContactPerson(int theId);
	
	public List<ContactPerson> clientContacts(ClientContactReport clientContactReport);

}
