package com.dontsov.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.dontsov.model.entity.User;
import com.dontsov.model.report.UserRoles;
import com.dontsov.service.RoleService;
import com.dontsov.service.SecurityService;
import com.dontsov.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
    private SecurityService securityService;
		
	@GetMapping("/list")
	public String listUsers(Model theModel) {
		
		theModel.addAttribute("users", userService.getUsers());		
		return "user/list-users";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("userId") int theId, Model theModel) {
		
		theModel.addAttribute("user", userService.getUser(theId));
		return "user/user-form";
		
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@Valid @ModelAttribute("user") User theUser,
			BindingResult theBindingResult) {
		if (theBindingResult.hasErrors()) {
			return "user/user-form";
		}
		else {
			userService.updateUser(theUser);
			return "redirect:/user/list";
		}
	}
	
	@GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("user", new User());
        return "user/registration";
    }

	@PostMapping("/registration")
    public String registration(@ModelAttribute("user") User theUser, BindingResult theBindingResult, Model model) {

        if (theBindingResult.hasErrors()) {
            return "user/registration";
        }

        userService.registration(theUser);
        securityService.autoLogin(theUser.getUsername(), theUser.getConfirmPassword());
		return "redirect:/user/list";
    }
	
	@GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }

        if (logout != null) {
            model.addAttribute("message", "Logged out successfully.");
        }

        return "login";
    }
	
	
	@GetMapping("/delete")
	public String deleteUser(@RequestParam("userId") int theId) {
		
		userService.deleteUser(theId);
		return "redirect:/user/list";
	}
	
	@GetMapping("/showUserRoles")
	public String showUserRoles(Model theModel) {
		UserRoles userRoles = new UserRoles();
		theModel.addAttribute("users", userService.getUsers());
		theModel.addAttribute("userRoles", userRoles);
		return "user/user-roles";
	}
	@PostMapping("/showUserRoles")
	public String showUserRoles(@ModelAttribute("userRoles") UserRoles userRoles, Model theModel) {
		theModel.addAttribute("userRoles", userService.getUserRoles(userRoles));
		theModel.addAttribute("userId", userRoles.getUserId());
		return "user/list-users-roles";
	}
	
	@GetMapping("/deleteRole")
	public String deleteUser(@RequestParam("roleId") int roleId , @RequestParam("userId") int userId) {
		userService.deleteUserRole(roleId, userId);
		return "redirect:/user/showUserRoles";
	}
	
	@GetMapping("/addRoleForUser")
	public String addRoleForUser(@RequestParam("userId") int userId, Model theModel) {
		UserRoles userRoles = new UserRoles();
		theModel.addAttribute("roles", roleService.getRoles());
		theModel.addAttribute("userId", userId);
		theModel.addAttribute("userRoles", userRoles);
		return "user/add-role-for-user";
	}
	
	@PostMapping("/addRoleForUser")
	public String addRoleForUser(@ModelAttribute("userRoles") UserRoles userRoles) {
		System.out.println("Роль + Юзер после добавления в роль пользователя " + userRoles);
		
		userService.addRoleForUser(userRoles);

		return "redirect:/user/showUserRoles";
	}
	
	@GetMapping("/accessDenied")
	public String accessDenied(Model theModel) {
		
		String userFullName = "";
		
		Authentication auth = SecurityContextHolder
		            .getContext().getAuthentication();
		     
		    if (auth != null) {
		         
		        Object principal = auth.getPrincipal();
		                 
		        if (principal instanceof org.springframework.security.core.userdetails.User) {
		        	org.springframework.security.core.userdetails.User userDetails = (org.springframework.security.core.userdetails.User) principal;
		        	userFullName = ((User) userService.findByUsername(userDetails.getUsername())).getFullName();
		        }
		    }
		    
		    if (userFullName!= "") {
			    theModel.addAttribute("userFullName", userFullName);
			}
		return "accessDenied";
	}
	
	@GetMapping("/welcome")
	public String welcome(Model theModel) {
		
		String userFullName = "";
		
		Authentication auth = SecurityContextHolder
		            .getContext().getAuthentication();
		     
		    if (auth != null) {
		         
		        Object principal = auth.getPrincipal();
		                 
		        if (principal instanceof org.springframework.security.core.userdetails.User) {
		        	org.springframework.security.core.userdetails.User userDetails = (org.springframework.security.core.userdetails.User) principal;
		        	userFullName = ((User) userService.findByUsername(userDetails.getUsername())).getFullName();
		        }
		    }
		    
		    if (userFullName!= "") {
			    theModel.addAttribute("userFullName", userFullName);
			}
		return "welcome";
	}
}
