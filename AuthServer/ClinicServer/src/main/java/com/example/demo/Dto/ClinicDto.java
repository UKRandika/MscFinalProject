package com.example.demo.Dto;



import lombok.Data;

@Data
public class ClinicDto {
	
	private String name;
	private String imagePath;
	private String address;
	private String emial;
	private String contact;
	private String longitude;
	private String latitude;
	private Long vetId;
	
	public ClinicDto() {
		super();
	}

	public ClinicDto(String name, String imagePath, String address, String emial, String contact, String longitude,
			String latitude, Long vetId) {
		super();
		this.name = name;
		this.imagePath = imagePath;
		this.address = address;
		this.emial = emial;
		this.contact = contact;
		this.longitude = longitude;
		this.latitude = latitude;
		this.vetId = vetId;
	}
	
	
	
}
