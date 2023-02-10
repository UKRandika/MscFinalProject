package com.example.demo.Services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.example.demo.Config.RandomPassowrdGenerator;
import com.example.demo.Email.EmailSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.Models.UserD;
import com.example.demo.Repositories.userRepository;

@Service
@Slf4j
//@RequiredArgsConstructor
public class userService implements UserDetailsService {
	
	 @Autowired
     private userRepository userRegRepository;
	 @Autowired
	 private JavaMailSender mailSender;
	@Autowired
	private PasswordEncoder passwordEncoder;
	 public String Registration(@Nullable UserD user) {
		 if(user.equals(null)){
			 return "Please send valid data";
		 }

		 UserD u = userRegRepository.findByUsername(user.getEmail());
		 if (u == null){
			 if(user.getRole().equals("VET_ROLE")) {
				 RandomPassowrdGenerator g = new RandomPassowrdGenerator();
				 String password = g.passwordGen();
				 user.setPassword(passwordEncoder.encode((password)));
				 user.setUsername(user.getEmail());
				 SimpleMailMessage message = new SimpleMailMessage();
				 message.setFrom("petdocmailsender@gmail.com");
				 message.setTo(user.getEmail());
				 message.setSubject("Thank you for Register with PETDOC");
				 message.setText("Your VET Account is Succussfully Activated and Password is : " + password + " please update this password ");
				 mailSender.send(message);
//				 EmailSender email = new EmailSender();
//				 email.sendEmail("Your VET Account is Succussfully Activated and Password is : " + password + "please update this password ",user.getEmail());
				 userRegRepository.save(user);
				 return "Regisretion Successfull";
			 }else{
				 user.setPassword(passwordEncoder.encode(user.getPassword()));
				 user.setUsername(user.getEmail());
				 userRegRepository.save(user);
				 SimpleMailMessage message = new SimpleMailMessage();
				 message.setFrom("petdocmailsender@gmail.com");
				 message.setTo(user.getEmail());
				 message.setSubject("Thank you for Register with PETDOC");
				 message.setText("Your Account is Succussfully Activated! Thank you for joining with us ");
				 mailSender.send(message);
				 return "Regisretion Successfull";
			 }
		 }else{
			 return "User Already Exists";
		 }

	 }

	 public List<UserD> getAllVets(){
		 String role = "VET_ROLE";
		 return userRegRepository.findByRole(role);
	 }
	public List<UserD> getAllUsers(){
		String role = "USER_ROLE";
		return userRegRepository.findByRole(role);
	}

 	public UserD userById(Long id) {
 		return userRegRepository.findById(id).orElse(null);
 	}
 	
 	public UserD update(UserD user) {
 		UserD existinguser = userRegRepository.findById(user.getId()).orElse(null);
 		existinguser.setFirstname(user.getFirstname());
 		existinguser.setLastname(user.getLastname());
 		existinguser.setContact(user.getContact());
 		existinguser.setEmail(user.getEmail());
 		existinguser.setPassword(user.getPassword());
        return userRegRepository.save(existinguser);
 	}

    public String deleteUser(Long id){
    	userRegRepository.deleteById(id);
        return "User Delete Successful";
    }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserD user = userRegRepository.findByEmail(username);
		if (user == null){
			log.error("User not found in the database");
			throw new UsernameNotFoundException("User not found in the database");
		}else{
			log.info("User found in the database: {}", username);
		}
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(user.getRole()));
		authorities.add(new SimpleGrantedAuthority(user.getId().toString()));
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
	}

	public String generatePasswordforVet(){
		RandomPassowrdGenerator r = new RandomPassowrdGenerator();
		return r.passwordGen();
	}

	public UserD userByEmail(String email) {

		 return userRegRepository.findByEmail(email);
	}
}
