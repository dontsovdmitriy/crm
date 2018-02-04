package com.dontsov.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dontsov.model.entity.*;
import com.dontsov.model.report.ClientContactReport;
import com.dontsov.service.ClientService;
import com.dontsov.service.ContactPersonService;

@Controller
@RequestMapping("/contactPerson")
public class ContactPersonController {

	@Autowired
	private ContactPersonService contactPersonService;
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping("/list")
	public String listContactPersons(Model theModel) {
		theModel.addAttribute("contactPersons", contactPersonService.getContactPersons());	
		return "contactPerson/list-contact-persons";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		ContactPerson theContactPerson = new ContactPerson();
		theModel.addAttribute("contactPerson", theContactPerson);
		theModel.addAttribute("contactPersonClient", clientService.getClients());
		return "contactPerson/contact-person-form";
	}
	
	@PostMapping("/saveContactPerson")
	public String saveContactPerson(@Valid @ModelAttribute("contactPerson") ContactPerson theContactPerson,
			BindingResult theBindingResult, Model theModel) {
		if (theBindingResult.hasErrors()) {
			theModel.addAttribute("contactPersonClient", clientService.getClients());
			return "contactPerson/contact-person-form";
		}
		else {
			contactPersonService.saveContactPerson(theContactPerson);
			return "redirect:/contactPerson/list";
		}
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("contactPersonId") int theId, Model theModel) {
				
		theModel.addAttribute("contactPerson", contactPersonService.getContactPerson(theId));
		theModel.addAttribute("contactPersonClient", clientService.getClients());
		return "contactPerson/contact-person-form";
		
	}
	
	@GetMapping("/delete")
	public String deleteContactPerson(@RequestParam("contactPersonId") int theId) {

		contactPersonService.deleteContactPerson(theId);		
		return "redirect:/contactPerson/list";
	}
	
	@GetMapping("/showFormForClientContactReport")
	public String showFormForClientContactReport(Model theModel) {
		ClientContactReport clientContactReport = new ClientContactReport();
		theModel.addAttribute("clientContactReport", clientContactReport);
		theModel.addAttribute("contactPersonClient", clientService.getClients());
		return "contactPerson/client-contact";
	}
	
	@PostMapping("/showClientContactReport")
	public String showClientContactReport	(@Valid @ModelAttribute("clientContactReport") ClientContactReport clientContactReport,
			BindingResult theBindingResult, Model theModel) {
		if (theBindingResult.hasErrors()) {
			theModel.addAttribute("contactPersonClient", clientService.getClients());
			return "contactPerson/client-contact";

		} else {
			theModel.addAttribute("contactPersons", contactPersonService.clientContacts(clientContactReport));	
				return "contactPerson/list-contact-persons";
		}
	}
}
