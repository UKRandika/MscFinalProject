package com.example.demo.Modules;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class MedicalHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date_time", nullable = false, updatable = false)
    private Date createdDateTime;
	@Column(nullable = false)
	private String content;
	private String symptoms;
	private String medication;
	private Double weight;
	private Double age;
	@ManyToOne
	@JoinColumn(name = "pet", insertable = false, updatable = false, referencedColumnName = "id")
	private PetDetails petDetails;
	private String prescriptionPath;
	@Column(nullable = false)
	private String petId;
	@Column(nullable = false)
	private Long vetId;
	@Column(nullable = false)
	private Long clinicId;

}
