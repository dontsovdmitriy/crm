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
import com.dontsov.model.entity.util.ClientStatus;
import com.dontsov.model.report.UserClientsReport;
import com.dontsov.service.ClientService;
import com.dontsov.service.UserService;

@Controller
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ClientService clientService;

	@Autowired
	private UserService userService;


	@GetMapping("/list")
	public String listClients(Model theModel) {
		theModel.addAttribute("clients", clientService.getClients());
		return "client/list-clients";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Client theClient = new Client();
		theModel.addAttribute("client", theClient);
		theModel.addAttribute("clientStatus", ClientStatus.values());
		theModel.addAttribute("clientUser", userService.getUsers());
		return "client/client-form";
	}

	@PostMapping("/saveClient")
	public String saveClient(@Valid @ModelAttribute("client") Client theClient,
			BindingResult theBindingResult, Model theModel) {	
		if (theBindingResult.hasErrors()) {
			theModel.addAttribute("clientUser", userService.getUsers());
			return "client/client-form";
		}
		else {
			clientService.saveClient(theClient);
			return "redirect:/client/list";
		}
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("clientId") int theId, Model theModel) {
		theModel.addAttribute("client", clientService.getClient(theId));
		theModel.addAttribute("clientType", ClientStatus.values());
		theModel.addAttribute("clientUser", userService.getUsers());
		return "client/client-form";

	}

	@GetMapping("/delete")
	public String deleteClient(@RequestParam("clientId") int theId) {
		clientService.deleteClient(theId);
		return "redirect:/client/list";
	}
	@GetMapping("/showFormForUserClientsReport")
	public String showFormForUserClientsReport(Model theModel) {
		UserClientsReport userClientsReport = new UserClientsReport();
		theModel.addAttribute("clientUser", userService.getUsers());
		theModel.addAttribute("userClientsReport", userClientsReport);
		return "client/client-user";
	}
	
	@PostMapping("/showUserClientsReport")
	public String showClientReport	(@Valid @ModelAttribute("userClientsReport") UserClientsReport userClientsReport,
			BindingResult theBindingResult, Model theModel) {
		if (theBindingResult.hasErrors()) {
			theModel.addAttribute("clientUser", userService.getUsers());
			return "client/client-user";
		} else {
			theModel.addAttribute("clients", clientService.userClientsReport(userClientsReport));	
				return "client/list-clients";
		}
	}
}
