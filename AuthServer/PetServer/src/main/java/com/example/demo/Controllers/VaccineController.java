package com.example.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Modules.MedicalHistory;
import com.example.demo.Modules.Vaccine;
import com.example.demo.Services.VaccineService;
import com.example.demo.dto.ResponseDto;
import com.example.demo.dto.VaccineDto;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/vaccine")
public class VaccineController {
	
	@Autowired
	private VaccineService vaccineService;
	
	@PostMapping("/save")
	public ResponseDto<Vaccine> save(@RequestBody VaccineDto data){
		try {
			Vaccine v = vaccineService.save(data);
			return new ResponseDto<Vaccine>().buildSuccessMsgWithData(v);
		}catch(Exception e) {
			return new ResponseDto<Vaccine>().buildFailureMsg(e.getMessage(), e);
		}
		
	}
	
	@GetMapping("/{id}")
	public List<Vaccine> getAllByPetId(@PathVariable String id) throws Exception{
		return vaccineService.getAllByPetId(id);
	}
}
