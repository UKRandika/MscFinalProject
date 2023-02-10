package com.example.demo.Controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.UserD;
import com.example.demo.Services.userService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class userController {
	
	@Autowired
	private userService userService;
	
	@PostMapping("/save")
	public String saveUser(@RequestBody UserD user) {
		return userService.Registration(user);
	}

	@GetMapping("/users")
	public List<UserD> getAllUsers(){
		return userService.getAllUsers();
	}

	@GetMapping("/vets")
	public List<UserD> getAllVets(){
		return userService.getAllVets();
	}

	@GetMapping("/{id}")
	public UserD getUser(@PathVariable Long id){
		return  userService.userById(id);
	}

	@GetMapping("/email/{email}")
	public UserD getUserByEmail(@PathVariable String email){
		return  userService.userByEmail(email);
	}
	@PutMapping("/update")
	public UserD updateUser(@RequestBody UserD user) {
		return userService.update(user);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable Long id) {
		return userService.deleteUser(id);
	}

	@GetMapping("/passwordGeneratoer")
	public String randomPasswordGenarater(){
		return userService.generatePasswordforVet();
	}
}
