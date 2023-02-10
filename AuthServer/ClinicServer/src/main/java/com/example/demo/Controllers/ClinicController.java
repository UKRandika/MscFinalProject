package com.example.demo.Controllers;

import com.example.demo.Modules.Clinic;
import com.example.demo.Modules.Position;
import com.example.demo.Serviceimplments.FileServiceImpl;
import com.example.demo.Servises.ClinicService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/clinics")
public class ClinicController {

    @Autowired
    private ClinicService clinicService;
    @Autowired
    private FileServiceImpl fileService;

    @PostMapping("/save")
    public Clinic saveClinic(@RequestParam("clinic") String clinic, @RequestParam("file")MultipartFile file) throws IOException  {
        Clinic c = new ObjectMapper().readValue(clinic, Clinic.class);
        if (file.isEmpty()) {
            throw new IllegalStateException("Cannot upload empty file");
        }
        if (!Arrays.asList(ContentType.IMAGE_PNG.getMimeType(),
                ContentType.IMAGE_BMP.getMimeType(),
                ContentType.IMAGE_GIF.getMimeType(),
                ContentType.IMAGE_JPEG.getMimeType()).contains(file.getContentType())) {
            throw new IllegalStateException("FIle uploaded is not an image");
        }
        //get file metadata
        Map<String, String> metadata = new HashMap<>();
        metadata.put("Content-Type", file.getContentType());
        metadata.put("Content-Length", String.valueOf(file.getSize()));

        //Save Image in S3 and then save Todo in the database
//		String path = "image";
//		String fileName = String.format(file.getOriginalFilename());
        String path = String.format("%s/%s", fileService.getBucketName(), "images");
        String fileName = String.format("%s", file.getOriginalFilename());
        try {
            fileService.store(path, fileName, Optional.of(metadata), file.getInputStream());
        } catch (IOException e) {
            throw new IllegalStateException("Failed to upload file", e);
        }
        String s3path = "https://petdocstorage.s3.amazonaws.com/images/";
        c.setImagePath(s3path+fileName);
        return clinicService.saveClinc(c);
    }

    @GetMapping("/")
    public List<Clinic> getAllClinics(){
        return clinicService.getAllClinics();
    }

    @GetMapping("/{email}")
    public List<Clinic> getAllClinicByVet(@PathVariable String email){
        return clinicService.getAllClinicsByVetemail(email);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return clinicService.deleteClinc(id);
    }
}
