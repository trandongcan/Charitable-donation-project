package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Donation;
import com.service.DonationService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private DonationService donationService;
	
	@GetMapping()
	private String home(Model model) {
		List<Donation> donations = donationService.getAllDonations();
		model.addAttribute("donations", donations);
		return "public/home";
	}
	
	@GetMapping("/system/users")
	public String account() {
		return "admin/account";
	}
}
