package com.example.demo.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Modules.MedicalHistory;
import com.example.demo.Services.MedicalHistoryService;
import com.example.demo.dto.MedicalHistoryDto;
import com.example.demo.dto.ResponseDto;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/med")
public class MedicalHistoryController {

	@Autowired
	private MedicalHistoryService medicalHistoryService;
	
	@PostMapping("/save")
	public ResponseDto<MedicalHistory> save(@RequestBody MedicalHistoryDto med){
		try {
			MedicalHistory medicalH= medicalHistoryService.save(med);		
			return new ResponseDto<MedicalHistory>().buildSuccessMsgWithData(medicalH);
		}catch(Exception e) {
			return new ResponseDto<MedicalHistory>().buildFailureMsg(e.getMessage(), e);
		}
	}
	
	@GetMapping("/{id}")
	public List<MedicalHistory> getAllByPetId(@PathVariable String id) throws Exception{

			return medicalHistoryService.getAllMedicalHistoryByPetId(id);
	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable Long id){
		return  this.medicalHistoryService.delete(id);
	}


}
