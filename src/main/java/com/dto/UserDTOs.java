package com.dto;

import java.util.Date;

import com.entity.Role;
import com.entity.User;
import com.repository.RoleRepository;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDTOs {
	
	//Lấy dữ liệu có sẵn từ database
	public UserDTOs(User user) {
		id = user.getId();
		userName = user.getUserName();
		password = user.getPassword();
		fullName = user.getFullName();
		email = user.getEmail();
		address = user.getAddress();
		phoneNumber = user.getPhoneNumber();
		note = user.getNote();
		status = user.getStatus();
		roleId = user.getRole().getId();
		roleName = user.getRole().getRoleName();
		createdAt = user.getCreatedAt();
	}
	
	public UserDTOs() {
		// TODO Auto-generated constructor stub
	}

	private int id;
	private String userName;
	private String password;
	private String fullName;
	private String email;
	private String address;
	private String phoneNumber;
	private String note;
	private int status;
	private int roleId;
	private String roleName;
	private String createdAt;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	
	
	
}
