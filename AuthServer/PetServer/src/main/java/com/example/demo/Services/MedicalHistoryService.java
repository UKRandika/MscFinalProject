package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import com.example.demo.Modules.MedicalHistory;
import com.example.demo.dto.MedicalHistoryDto;

public interface MedicalHistoryService {
	
	 MedicalHistory save(MedicalHistoryDto data) throws Exception;
	 
	 List<MedicalHistory> getAllMedicalHistoryByPetId(String id) throws Exception;

	 String delete(Long id);
}
