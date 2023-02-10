package com.example.demo.Services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.Modules.MedicalHistory;
import com.example.demo.Modules.PetDetails;
import com.example.demo.Repositories.MedicalHistoryRepository;
import com.example.demo.Repositories.PetRepository;
import com.example.demo.Services.MedicalHistoryService;
import com.example.demo.dto.MedicalHistoryDto;
import com.example.demo.util.converter.EntityConverter;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MedicalHistoryServiceImpl implements MedicalHistoryService{

	private final MedicalHistoryRepository medicalRepository;
	private final PetRepository petRepository;
	private final EntityConverter entityConverter;
	
	@Override
	public MedicalHistory save(MedicalHistoryDto data) throws Exception{
		
		//finding valid pet
		Optional<PetDetails> petDetailsOptional = petRepository.findById(data.getPetId());
		petDetailsOptional.orElseThrow(()->new Exception("Invalid pet Id"));
		
		//vet and clinic id check must be added.
		MedicalHistory medicalH = entityConverter.convert(data, MedicalHistory.class);
		medicalH.setPetId(data.getPetId());
		medicalH.setPetDetails(petDetailsOptional.get());
		return medicalRepository.save(medicalH);
	}

	@Override
	public List<MedicalHistory> getAllMedicalHistoryByPetId(String id) throws Exception {
		
		//finding valid pet
        Optional<PetDetails> petDetailsOptional = petRepository.findById(id);
        petDetailsOptional.orElseThrow(()->new Exception("Invalid pet Id! "));
        
        Optional<List<MedicalHistory>> medicalHistory = Optional.of(medicalRepository.findByPetId(id));
        medicalHistory.orElseThrow(() -> new Exception("Medical History does not exist for this Pet! "));
        //sending data
		return medicalRepository.findByPetId(id);
	}

	@Override
	public String delete(Long id) {
		medicalRepository.deleteById(id);
		return "Deleted";
	}

	//update
	//delete


}
