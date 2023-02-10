package com.example.demo.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Modules.MedicalHistory;
import com.example.demo.Modules.PetDetails;

public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory, Long> {

	List<MedicalHistory> findByPetId(String id);

}
