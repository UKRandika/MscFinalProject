package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Modules.PetDetails;
import com.example.demo.Repositories.PetRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PetService {
	
	@Autowired
	private PetRepository petRepository;
	String message = null;

	
	//saving a pet
	public String save(PetDetails pet)  {
		boolean exists;
		try {
			exists = petRepository.existsById(pet.getId());
			if(pet.equals(null)) {
				message =  "Please send valid data! ";
			}
			else if(exists) {
				message =  "Pet Already Registered to the system! ask previous owner to change owner!";
			}
			else {

				petRepository.save(pet);
				message = "Pet Registration Successful";
			}
		}catch(Exception e){
			return e.getMessage();
		}
		return message;
	}
	
	
	//all pet details
	public List<PetDetails> getAll(){
		return petRepository.findAll();
	}
	
	//pet by Id
	public PetDetails getByRegNumber( String id) {
		boolean exists;
		exists = petRepository.existsById(id);
		if(exists) {
			return petRepository.findById(id).orElse(null);
		}
		else {
			return null;
		}
	}

	//petByOwnerId
	public List<PetDetails> getPetByOwner(String ownerEmail){
		return petRepository.findByOwnerEmail(ownerEmail);
	}
	//update pet owner
	public PetDetails updateOwner(PetDetails petDetails) {
		
			PetDetails pet = petRepository.findById(petDetails.getId()).orElse(null);
			pet.setOwnerEmail(petDetails.getOwnerEmail());
			return petRepository.save(pet);
	}

	
	//update pet profilepic
	public PetDetails updatePetProfilePic(PetDetails petDetails) {
		PetDetails pet = petRepository.findById(petDetails.getId()).orElse(null);
		pet.setImagePath(petDetails.getImagePath());
		return petRepository.save(pet);
	}
	
	//update pet family
	public PetDetails updateFamily(PetDetails petDetails) {
		PetDetails pet = petRepository.findById(petDetails.getId()).orElse(null);
		pet.setFather(petDetails.getFather());
		pet.setMother(petDetails.getMother());
		return petRepository.save(pet);
	}
	
	//update Address
	public PetDetails updateAddress(PetDetails petDetails) {
		PetDetails pet = petRepository.findById(petDetails.getId()).orElse(null);
		pet.setAddress(petDetails.getAddress());
		return petRepository.save(pet);
	}
	
	//update pet other details
	public PetDetails updatePetOther(PetDetails petDetails){
		PetDetails pet = petRepository.findById(petDetails.getId()).orElse(null);
		pet.setName(petDetails.getName());
		pet.setCategory(petDetails.getCategory());
		pet.setBreed(petDetails.getBreed());
		pet.setDateOfBirth(petDetails.getDateOfBirth());
		pet.setGender(petDetails.getGender());
		
		return petRepository.save(pet);
	}
	
	//pet Delete
	public String deletePet(String id) {
		boolean exists;
		exists = petRepository.existsById(id);
		if(exists) {
//			PetDetails pet = petRepository.findById(id).orElse(null);
			petRepository.deleteById(id);
			return "Pet Deleted! ";
		}
		else {
			return "Selected pet does not exists! ";
		}	
	}
}
