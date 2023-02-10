package com.example.demo.Serviceimplments;

import com.example.demo.Modules.Clinic;
import com.example.demo.Repositories.ClinicRepository;
import com.example.demo.Servises.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ClinicImpl implements ClinicService {
    @Autowired
    private ClinicRepository clinicRepository;

    @Override
    public Clinic saveClinc(Clinic data) throws IOException {
        String position = "lat: "+ data.getLatitude() +", lng: "+ data.getLongitude();
        data.setPosition(position);
        return clinicRepository.save(data);
    }

    @Override
    public List<Clinic> getAllClinicsByVetemail(String email) {
        return clinicRepository.findByVetEmail(email);
    }

    @Override
    public List<Clinic> getAllClinics() {
        return clinicRepository.findAll();
    }

    @Override
    public Clinic getById(Long id) {
        return clinicRepository.findById(id).orElse(null);
    }

    @Override
    public String deleteClinc(Long id) {
        boolean exists = clinicRepository.existsById(id);
        if(exists){
            clinicRepository.deleteById(id);
            return "Delete Successful";
        }
        return "Delete Unsuccessful";
    }
}