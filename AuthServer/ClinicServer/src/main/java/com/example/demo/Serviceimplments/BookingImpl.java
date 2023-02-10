package com.example.demo.Serviceimplments;

import com.example.demo.Dto.BookingDto;
import com.example.demo.Modules.Booking;
import com.example.demo.Servises.BookingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingImpl implements BookingService {
    @Override
    public Booking save(BookingDto data) throws Exception {
        return null;
    }

    @Override
    public List<Booking> getByClinicId(Long id) {
        return null;
    }

    @Override
    public List<Booking> getByVetId(Long id) {
        return null;
    }

    @Override
    public List<Booking> getByClinicIdAndVetId(Long clinicId, Long vetId) {
        return null;
    }

    @Override
    public Booking updateAction(BookingDto data) throws Exception {
        return null;
    }
}
