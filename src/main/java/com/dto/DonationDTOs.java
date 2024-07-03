package com.dto;

import java.util.List;

import com.entity.Donation;
import com.entity.User;

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
public class DonationDTOs {
	
	//Lấy dữ liệu có sẵn từ database
	public DonationDTOs(Donation donation) {
		id = donation.getId();
		code = donation.getCode();
		name = donation.getName();
		description = donation.getDescription();
		money = donation.getMoney();
		startDate = donation.getStartDate();
		endDate = donation.getEndDate();
		status = donation.getStatus();
		organizationName = donation.getOrganizationName();
		phoneNumber = donation.getPhoneNumber();
		users = donation.getUsers();
	}
	
	

	public DonationDTOs() {
		// TODO Auto-generated constructor stub
	}



	private int id;
	private String code;
	private String name;
	private String description;
	private int money;
	private String startDate;
	private String endDate;
	private int status;
	private String organizationName;
	private String phoneNumber;
	private List<User> users;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
}
