package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Modules.PetDetails;

import java.util.List;

public interface PetRepository extends JpaRepository<PetDetails, String> {

    List<PetDetails> findByOwnerEmail(String ownerEmail);
}
