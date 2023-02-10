package com.example.demo.Services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.Modules.PetDetails;
import com.example.demo.Modules.Vaccine;
import com.example.demo.Repositories.PetRepository;
import com.example.demo.Repositories.VaccineRepository;
import com.example.demo.Services.VaccineService;
import com.example.demo.dto.VaccineDto;
import com.example.demo.util.converter.EntityConverter;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VaccineServiseimpl implements VaccineService {
	
	private final VaccineRepository vaccineRepository;
	private final PetRepository petRepository;
	private final EntityConverter entityConverter;
	
	@Override
	public Vaccine save(VaccineDto data) throws Exception {
		
		Optional<PetDetails> petDetailsOptional = petRepository.findById(data.getPetId());
		petDetailsOptional.orElseThrow(()->new Exception("Invalid pet Id"));
		Vaccine v = entityConverter.convert(data, Vaccine.class);
		v.setPetId(data.getPetId());
		return vaccineRepository.save(v);
	}

	@Override
	public List<Vaccine> getAllByPetId(String id) throws Exception {
		//finding valid pet
        Optional<PetDetails> petDetailsOptional = petRepository.findById(id);
        petDetailsOptional.orElseThrow(()->new Exception("Invalid pet Id! "));
        
        return vaccineRepository.findByPetId(id);
	}

}
