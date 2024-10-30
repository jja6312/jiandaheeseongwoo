package com.ssafy.exam.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.exam.model.dto.Specialty;
import com.ssafy.exam.model.service.SpecialtyService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/specialty")
@Tag(name = "전공", description = "전공 정보와 관련된 api들입니다.")
public class SpecialtyRestController {
	private SpecialtyService specialtyService;//서비스
	
	//생성자 주입
	public SpecialtyRestController(SpecialtyService specialtyService) {
		this.specialtyService = specialtyService;
	}
	
	// 전공 정보 등록	
	@PostMapping
	@Operation(summary = "전공 정보 등록",description = "전공 정보를 등록합니다.")
    public ResponseEntity<String> addSpecialty(@RequestBody Specialty specialty) {
		boolean isSuccessAdd = specialtyService.addSpecialty(specialty); // 등록 성공 여부
    	
		//등록에 성공했다면 201 created 반환, 실패했다면 500 Error 반환
		return isSuccessAdd 
    			? ResponseEntity.status(HttpStatus.CREATED).body("Specialty added successfully")
    			: ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add specialty");
    }
	
	@GetMapping
	@Operation(summary = "모든 전공 정보 조회",description = "모든 전공 정보를 조회합니다.")
    public ResponseEntity<List<Specialty>> getAllSpecialties() {
		List<Specialty> specialty = specialtyService.getAllSpecialties();
		if(specialty.size()>0)  return ResponseEntity.status(HttpStatus.OK).body(specialty);
		else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
	
	
	// code에 따른 전공 정보 조회
	@GetMapping("/{code}")
	@Operation(summary = "전공 정보 조회",description = "전공 정보를 조회합니다.")
    public ResponseEntity<Specialty> getSpecialty(@PathVariable int code) {
		Specialty specialty = specialtyService.getSpecialtyByCode(code);
		if(specialty != null)  return ResponseEntity.status(HttpStatus.OK).body(specialty);
		else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
	
	// 삭제
	@DeleteMapping("/{code}")
	@Operation(summary = "전공 정보 삭제",description = "전공 정보를 삭제합니다.")
    public ResponseEntity<String> deleteSpecialty(@PathVariable int code) {
		boolean isSuccessDelete = specialtyService.deleteSpecialty(code);
    	return isSuccessDelete 
    			? ResponseEntity.status(HttpStatus.OK).body("Specialty deleted successfully")
    			: ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete specialty");
    }
}