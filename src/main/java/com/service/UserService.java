package com.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.Role;
import com.entity.User;
import com.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleService roleService;
	
	@Transactional
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	@Transactional
	public void addNewUser(User newUserDTO) {
		Role role = newUserDTO.getRole();
		User newUser = new User(newUserDTO);
		System.out.println("service: " + newUser);
		
		newUser.setRole(role);
		userRepository.save(newUser);
	}
	
	@Transactional
	public void lockUser(int userId) {
		Optional<User> result = userRepository.findById(userId);
		if (result.isPresent()) {
			User user = result.get();
			
			int status = user.getStatus() == 0 ? 1 : 0;
			user.setStatus(status);
			
			userRepository.save(user);
		}
	}
	
	@Transactional
	public void updateUser(int userId, String fullName, String phoneNumber, String address, int roleId) {
		Optional<User> result = userRepository.findById(userId);
		if (result.isPresent()) {
			User user = result.get();
			user.setFullName(fullName);
			user.setPhoneNumber(phoneNumber);
			user.setAddress(address);
			
			if (user.getRole().getId() != roleId) {
				Role role = roleService.getRole(roleId);
				user.setRole(role);
			}
			userRepository.save(user);
			System.out.println("Update user successfully");
		}
	}
	
	@Transactional
	public void deleteUser(int userId) {
		userRepository.deleteById(userId);	
	}
}
