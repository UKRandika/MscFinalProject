package com.example.demo.Servises;

import java.io.IOException;
import java.util.List;

import com.example.demo.Modules.Clinic;

public interface ClinicService {
	
	Clinic saveClinc(Clinic data) throws IOException;
	List<Clinic> getAllClinicsByVetemail(String email);
	List<Clinic> getAllClinics();
	Clinic getById(Long id);
	 String deleteClinc(Long id);
}
