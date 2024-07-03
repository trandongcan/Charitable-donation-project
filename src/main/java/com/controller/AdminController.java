package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.Donation;
import com.entity.Role;
import com.entity.User;
import com.service.DonationService;
import com.service.RoleService;
import com.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private DonationService donationService;
	
	@GetMapping()
	public String adminHome() {
		return "home";
	}
	
	@GetMapping("/manage-users")
	public String manageUser(Model model) {
		List<User> usersDTO = userService.getAllUsers(); 
		List<Role> roles = roleService.getAllRoles(); 
		User newUserDTO = new User();	  
		
		model.addAttribute("users", usersDTO);
		model.addAttribute("newUser", newUserDTO);
		model.addAttribute("roles", roles);
		return "admin/account";	
	}
	
	@PostMapping("/add-new-user")
	public String addNewUser(@ModelAttribute("newUser") User userDTO) {
		System.out.println("controller: " + userDTO);
		userService.addNewUser(userDTO);
		
		return "redirect:/admin/manage-users";
	}
	
	@PostMapping("/lock-user")
	public String lockUser(@RequestParam("userId") int userId) {
		userService.lockUser(userId);
		return "redirect:/admin/manage-users";
	}
	
	@PostMapping("/update-user")
	public String updateUser(
			@RequestParam("userId") int userId,
			@RequestParam("fullName") String fullName,
			@RequestParam("phoneNumber") String phoneNumber,
			@RequestParam("address") String address,
			@RequestParam("roleId") int roleId
			) {
		userService.updateUser(userId, fullName, phoneNumber, address, roleId);
		
		return "redirect:/admin/manage-users";
	}
	
	@PostMapping("/delete-user")
	public String deleteUser(@RequestParam("userId") int userId) {
		System.out.println("------------" + userId);
		userService.deleteUser(userId);
		return "redirect:/admin/manage-users";
	}
	
	@GetMapping("/manage-donations")
	public String manageDonation(Model model) {
		List<Donation> donationsDTO = donationService.getAllDonations();
		Donation newDonationDTO = new Donation();
		
		model.addAttribute("donations", donationsDTO);
		model.addAttribute("newDonation", newDonationDTO);
		
		return "admin/donation";
	}
	
	@PostMapping("/add-new-donation")
	public String addNewDonation(@ModelAttribute("newDonation") Donation donationDTO) {
		System.out.println(donationDTO);
		donationService.addNewDonation(donationDTO);
		return "redirect:/admin/manage-donations";
	}
	
	@PostMapping("/delete-donation")
	public String deleteDonation(@RequestParam("donationId") int donationId) {
		donationService.deleteDonation(donationId);
		return "redirect:/admin/manage-donations";
	}
	
	@GetMapping("/detail/{donationId}")
	public String detailDonation(@PathVariable("donationId") int donationId, Model model) {
		Donation donationDTO = donationService.getDonation(donationId);
		System.out.println("--------" + donationDTO);
		model.addAttribute("donation", donationDTO);
		return "admin/detail";
	}
	
	@PostMapping("/change-donation-status") 
	public String changeDonationStatus(@RequestParam("donationId") int donationId) {
		donationService.changeStatus(donationId);
		return "redirect:/admin/manage-donations";
	}
}
