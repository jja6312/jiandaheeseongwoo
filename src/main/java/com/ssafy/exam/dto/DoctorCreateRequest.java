package com.ssafy.exam.dto;

import com.ssafy.exam.model.dto.Doctor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;


@Getter
@Setter
public class DoctorCreateRequest {
    private int doctorId;
    private String name;
    private int age;
    private int specialtyCode;
    private int experienceYears;
    private String specialtyName;
    private MultipartFile image;

}
