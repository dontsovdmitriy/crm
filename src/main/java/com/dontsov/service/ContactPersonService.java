package com.dontsov.service;

import java.util.List;

import com.dontsov.model.entity.*;
import com.dontsov.model.report.ClientContactReport;

public interface ContactPersonService {

	public List<ContactPerson> getContactPersons();

	public void saveContactPerson(ContactPerson theContactPerson);

	public ContactPerson getContactPerson(int theId);

	public void deleteContactPerson(int theId);
	
	public List<ContactPerson> clientContacts(ClientContactReport clientContactReport);

}
