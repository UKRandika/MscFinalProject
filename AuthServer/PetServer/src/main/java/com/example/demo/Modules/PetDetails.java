package com.example.demo.Modules;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class PetDetails {
	
	@Id
	@Column(nullable = false, unique = true)
	private String id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String gender;
	@Column(nullable = false)
	private String category;
	private String breed;
	@JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private String dateOfBirth;
	@Column(nullable = false)
	private String ownerEmail;
	@Column(nullable = false)
	private String address;
	private String imagePath;
	@OneToMany(mappedBy = "petDetails")
	private List<MedicalHistory> medHistory;
	@OneToMany(mappedBy = "petDetails")
	private List<Vaccine> vaccine;
	private String father;
	private String mother;
//	@ManyToMany(mappedBy = "petDetails")
//	private List<OwnerHistory> ownerHistories;

}
