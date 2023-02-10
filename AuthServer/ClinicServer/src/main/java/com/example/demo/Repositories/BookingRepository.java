package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Modules.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long>  {

}
