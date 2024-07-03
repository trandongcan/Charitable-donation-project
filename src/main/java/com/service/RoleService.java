package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Role;
import com.repository.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Transactional
	public Role getRole(int roleId) {
		Optional<Role> result = roleRepository.findById(roleId);
		if (result.isPresent()) {
			return result.get();
		} else return null;
	}
	
	@Transactional
	public List<Role> getAllRoles() {
		return roleRepository.findAll();
	}
}
