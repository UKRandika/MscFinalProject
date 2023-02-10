package com.example.demo.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Modules.Vaccine;

public interface VaccineRepository extends JpaRepository<Vaccine, Long> {

	List<Vaccine> findByPetId(String id);

}
