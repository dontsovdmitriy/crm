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


import com.dontsov.model.entity.Target;
import com.dontsov.service.TargetService;

@Controller
@RequestMapping("/target")
public class TargetController {

	@Autowired
	private TargetService targetService;
	
	@GetMapping("/list")
	public String listTargets(Model theModel) {
				
		theModel.addAttribute("targets", targetService.getTargets());
		return "target/list-targets";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Target theTarget = new Target();
		theModel.addAttribute("target", theTarget);
		return "target/target-form";
	}
	
	@PostMapping("/saveTarget")
	public String saveTarget(@Valid @ModelAttribute("target") Target theTarget,
			BindingResult theBindingResult) {
		if (theBindingResult.hasErrors()) {
			return "target/target-form";
		}
		else {
			targetService.saveTarget(theTarget);
			return "redirect:/target/list";
		}
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("targetId") int theId, Model theModel) {

		theModel.addAttribute("target", targetService.getTarget(theId));
		return "target/target-form";
		
	}
	
	@GetMapping("/delete")
	public String deleteTarget(@RequestParam("targetId") int theId) {
		
		targetService.deleteTarget(theId);
		return "redirect:/target/list";
	}
}
