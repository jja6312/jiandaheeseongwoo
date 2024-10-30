package com.ssafy.exam.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.exam.model.dto.Doctor;
import com.ssafy.exam.model.service.DoctorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/doctor")
@Tag(name = "의사", description = "의사와 관련된 api들입니다.")
public class DoctorRestController {
	private DoctorService doctorService;
	
	//생성자 주입
	public DoctorRestController(DoctorService doctorService) {
		this.doctorService = doctorService;
	}

	// 의사 등록
	@PostMapping
	@Operation(summary = "의사 등록",description = "의사 정보를 등록합니다.")
	public ResponseEntity<String> addDoctor(@RequestBody Doctor doctor) {
		boolean isSuccessAdd = doctorService.addDoctor(doctor);
		return isSuccessAdd
				? ResponseEntity.status(HttpStatus.CREATED).body("Doctor added successfully")
		    	: ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add doctor");
	}

	// 모든 의사 정보 조회
	@GetMapping
	@Operation(summary = "모든 의사 조회",description = "모든 의사의 정보를 조회합니다.")
	public ResponseEntity<List<Doctor>> getAllDoctors() {
		List<Doctor> doctors = doctorService.getAllDoctors();
		
		return doctors.size()>0
				? ResponseEntity.status(HttpStatus.OK).body(doctors)
				: ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		
	}

	// 의사 id에 따른 의사 정보 조회
	@GetMapping("/{id}")
	@Operation(summary = "id에 따른 의사 정보 조회",description = "특정 의사 정보를 조회합니다.")
	public ResponseEntity<Doctor> getDoctorById(@PathVariable int id) {
		Doctor doctor = doctorService.getDoctorById(id);
		return doctor != null
				? ResponseEntity.status(HttpStatus.OK).body(doctor)
				: ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	// 의사 id에 해당하는 의사 정보 수정
	@PutMapping("/{id}")
	@Operation(summary = "id에 따른 의사 정보 수정",description = "특정 의사 정보를 수정합니다.")
	public ResponseEntity<String> updateDoctor(@PathVariable int id, @RequestBody Doctor doctor) {
		boolean isUpdatedSuccess = doctorService.updateDoctor(id, doctor);
		return isUpdatedSuccess
				? ResponseEntity.status(HttpStatus.OK).body("Doctor updated successfully")
				: ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update doctor");
	}

	// 의사 삭제
	@DeleteMapping("/{id}")
	@Operation(summary = "id에 따른 의사 정보 삭제",description = "의사 정보를 삭제합니다.")
	public ResponseEntity<String> deleteDoctor(@PathVariable int id) {
		boolean isDeletedSuccess = doctorService.deleteDoctor(id);
		return isDeletedSuccess
				? ResponseEntity.status(HttpStatus.OK).body("Doctor deleted successfully")
				: ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete doctor");
	}
}
