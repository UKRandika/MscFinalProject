package com.example.demo.Controllers;

import java.io.IOException;
import java.util.*;

import com.example.demo.Services.impl.FileServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Modules.PetDetails;
import com.example.demo.Repositories.PetRepository;
import com.example.demo.Services.PetService;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/pet")
public class PetController {
	
	@Autowired
	private PetService petService;
	@Autowired
	private FileServiceImpl fileService;
	@PostMapping("/save")
	public String save(@RequestParam("pet") String pet, @RequestParam("file") MultipartFile file)throws IOException {
		PetDetails p = new ObjectMapper().readValue(pet, PetDetails.class);
		if (file.isEmpty()) {
			throw new IllegalStateException("Cannot upload empty file");
		}

		//Check if the file is an image
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
		p.setImagePath(s3path+fileName);
		return petService.save(p);
	}
	
	@GetMapping("/")
	public List<PetDetails> getAll(){
		return petService.getAll();
	}
	
	@GetMapping("/{id}")
	public PetDetails getByRegNumber(@PathVariable String id) {
		return petService.getByRegNumber(id);
	}

	@GetMapping("/owner/{email}")
	public List<PetDetails> getByOwnerId(@PathVariable String email) {
		return petService.getPetByOwner(email);
	}

	@PutMapping("/update/other")
	public PetDetails updatePet(@RequestBody PetDetails petDetails) {
		return petService.updatePetOther(petDetails);
	}
	
	@PutMapping("/update/owner")
	public PetDetails updatePetOwner(@RequestBody PetDetails petDetails) {
		return petService.updateOwner(petDetails);
	}
	
	@PutMapping("/update/pic")
	public PetDetails updatePetPic(@RequestBody PetDetails petDetails) {
		return petService.updatePetProfilePic(petDetails);
	}
	
	@PutMapping("/update/family")
	public PetDetails updatePetFamily(@RequestBody PetDetails petDetails) {
		return petService.updateFamily(petDetails);
	}
	
	@PutMapping("/update/address")
	public PetDetails updatePetAddress(@RequestBody PetDetails petDetails) {
		return petService.updateAddress(petDetails);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deletePet(@PathVariable String id){
			return petService.deletePet(id);		
	}
	
	
}
