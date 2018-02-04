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
import com.dontsov.model.entity.util.*;
import com.dontsov.model.report.ActionClientReport;
import com.dontsov.service.*;

@Controller
@RequestMapping("/action")
public class ActionController {

	@Autowired
	private ActionService actionService;

	@Autowired
	private ClientService clientService;

	@Autowired
	private TargetService targetService;

	@GetMapping("/list")
	public String listActions(Model theModel) {
		theModel.addAttribute("actions", actionService.getActions());
		return "action/list-actions";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Action theAction = new Action();
		theModel.addAttribute("action", theAction);
		theModel.addAttribute("actionClient", clientService.getClients());
		theModel.addAttribute("actionType", ActionType.values());
		theModel.addAttribute("actionTarget", targetService.getTargets());
		return "action/action-form";
	}

	@PostMapping("/saveAction")
	public String saveClient(@Valid @ModelAttribute("action") Action theAction,
			BindingResult theBindingResult, Model theModel) {
		if (theBindingResult.hasErrors()) {
			theModel.addAttribute("actionClient", clientService.getClients());
			theModel.addAttribute("actionTarget", targetService.getTargets());
			return "action/action-form";
		}
		else {
			actionService.saveAction(theAction);
			return "redirect:/action/list";
		}
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("actionId") int theId, Model theModel) {
		theModel.addAttribute("action", actionService.getAction(theId));
		theModel.addAttribute("actionClient", clientService.getClients());
		theModel.addAttribute("actionType", ActionType.values());
		theModel.addAttribute("actionTarget", targetService.getTargets());
		return "action/action-form";
	}

	@GetMapping("/delete")
	public String deleteAction(@RequestParam("actionId") int theId) {
		actionService.deleteAction(theId);
		return "redirect:/action/list";
	}
	
	@GetMapping("/showFormForClientReport")
	public String showFormForClientReport(Model theModel) {
		ActionClientReport actionClientReport = new ActionClientReport();
		theModel.addAttribute("actionClientReport", actionClientReport);
		theModel.addAttribute("actionClient", clientService.getClients());
		return "action/client-action";
	}
	
	@PostMapping("/showClientReport")
	public String showClientReport	(@Valid @ModelAttribute("actionClientReport") ActionClientReport actionClientReport,
			BindingResult theBindingResult, Model theModel) {
		if (theBindingResult.hasErrors()) {
			theModel.addAttribute("actionClient", clientService.getClients());
			return "action/client-action";

		} else {
			theModel.addAttribute("actions", actionService.clientReport(actionClientReport));	
				return "action/list-actions";
		}
	}

}

