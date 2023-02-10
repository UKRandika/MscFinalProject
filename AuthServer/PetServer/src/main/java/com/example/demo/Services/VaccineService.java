package com.example.demo.Services;

import java.util.List;

import com.example.demo.Modules.Vaccine;
import com.example.demo.dto.VaccineDto;

public interface VaccineService {

	Vaccine save(VaccineDto data) throws Exception;
	
	List<Vaccine> getAllByPetId(String id) throws Exception;
}
