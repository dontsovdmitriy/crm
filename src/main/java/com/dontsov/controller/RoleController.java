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

import com.dontsov.model.entity.Role;
import com.dontsov.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@GetMapping("/list")
	public String listRoles(Model theModel) {
	
		theModel.addAttribute("roles", roleService.getRoles());
	
		return "role/list-roles";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Role theRole = new Role();
		theModel.addAttribute("role", theRole);
		return "role/role-form";
	}
	
	@PostMapping("/saveRole")
	public String saveRole(@Valid @ModelAttribute("role") Role theRole,
			BindingResult theBindingResult) {
		if (theBindingResult.hasErrors()) {
			return "role/role-form";
		}
		else {
			roleService.saveRole(theRole);
			return "redirect:/role/list";
		}
		
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("roleId") int theId, Model theModel) {

		theModel.addAttribute("role", roleService.getRole(theId));
		return "role/role-form";
		
	}
	
	@GetMapping("/delete")
	public String deleteRole(@RequestParam("roleId") int theId) {
		
		roleService.deleteRole(theId);
		return "redirect:/role/list";
	}
}
