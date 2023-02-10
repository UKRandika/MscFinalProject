package com.example.demo.Models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class UserD {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstname;
	private String lastname;
	@Column(unique = true)
	private String username;
	@Column(unique = true)
	private String email;
	private Long contact;
    private String role;
    private String password;
	@Column(unique = true)
	private String referenceNumber;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date_time", nullable = false, updatable = false)
	private Date createdDateTime;
	private boolean isBlocked;

}
