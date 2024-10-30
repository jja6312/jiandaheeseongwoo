package com.ssafy.exam.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Doctor {
	private int doctorId;
	private String name;
	private int age;
	private int specialtyCode;
	private int experienceYears;
	private String specialtyName;
	private String profileImageUrl;


}
