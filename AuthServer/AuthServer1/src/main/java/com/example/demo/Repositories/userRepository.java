package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Models.UserD;
import org.springframework.lang.Nullable;

import java.util.List;

public interface userRepository extends JpaRepository<UserD, Long>{


	UserD findByEmail(String email);

    UserD findByUsername(String username);

    List<UserD> findByRole(String role);
}
