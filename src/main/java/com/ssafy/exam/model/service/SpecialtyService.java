package com.ssafy.exam.model.service;

import java.util.ArrayList;

import com.ssafy.exam.model.dto.Specialty;

public interface SpecialtyService {
	boolean addSpecialty(Specialty specialty);

	Specialty getSpecialtyByCode(int code);

	boolean deleteSpecialty(int code);

	ArrayList<Specialty> getAllSpecialties();
}