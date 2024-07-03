package com.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Donation;
import com.repository.DonationRepository;

@Service
public class DonationService {

	@Autowired
	private DonationRepository donationRepository;
	
	@Transactional
	public List<Donation> getAllDonations() {
		return listDonationToListDonationDTO(donationRepository.findAll());
	}
	
	@Transactional
	public void addNewDonation(Donation donationDTO) {
		Donation newDonation = new Donation(donationDTO);
		donationRepository.save(newDonation);
	}
	
	@Transactional
	public void deleteDonation(int donationId) {
		Optional<Donation> result = donationRepository.findById(donationId);
		if (result.isPresent()) {
			Donation donation = result.get();
			if (donation.getStatus() == 0) {	
				donationRepository.delete(donation);
				System.out.println("Delete donation (id = " + donationId + ") successfully");
			}
		}
	}
	
	@Transactional
	public Donation getDonation(int donationId) {
		Optional<Donation> result = donationRepository.findById(donationId);
		
		if (result.isPresent()) {
			Donation donation = result.get();
			return donation;
		}
		else return null;
	}
	
	@Transactional
	public void changeStatus(int donationId) {
		Optional<Donation> result= donationRepository.findById(donationId);
		if (result.isPresent()) {
			Donation donation = result.get();
			
			switch (donation.getStatus()) {
				case 0: donation.setStatus(1);
						break;
				case 1: donation.setStatus(2);
						break;
				case 2: donation.setStatus(3);
						break;
			}
			donationRepository.save(donation);
			System.out.println("Change donation status successfully");
		}
	}
	
	//Vấn đề nằm ở đây. nó trả về có id hết, nhưng khi e new Donation thì nó id là 0
	public List<Donation> listDonationToListDonationDTO(List<Donation> donations) {
		List<Donation> donationsDTO = donations.stream()
			.map(donation -> {
				var d = new Donation(donation);
				d.setId(donation.getId());
				return d;
			})
			.collect(Collectors.toList());
		return donationsDTO;
	}
}
