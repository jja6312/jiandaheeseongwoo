package com.ssafy.exam.model.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.ssafy.exam.model.dao.SpecialtyDao;
import com.ssafy.exam.model.dto.Specialty;

@Service
public class SpecialtyServiceImpl implements SpecialtyService {
	private SpecialtyDao specialtyDao; // dao
	
	//생성자 주입
	public SpecialtyServiceImpl(SpecialtyDao specialtyDao) {
		this.specialtyDao = specialtyDao;
	}
	

	// 등록
	@Override
	public boolean addSpecialty(Specialty specialty) {
		// Dao의 insert 수행.
		// + 반환값을 메모리에 남기지 않고 true or false 처리
		return specialtyDao.insertSpecialty(specialty) > 0 ? true : false;
	}

	// 조회
	@Override
	public Specialty getSpecialtyByCode(int code) {
		return specialtyDao.selectSpecialtyByCode(code);
	}

	// 삭제
	@Override
	public boolean deleteSpecialty(int code) {
		return specialtyDao.deleteSpecialty(code) > 0 ? true : false;
	}


	@Override
	public ArrayList<Specialty> getAllSpecialties() {
		return specialtyDao.selectAllSepcialty();
	}

}
