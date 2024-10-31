package com.ssafy.exam.dto;

import com.ssafy.exam.model.dto.Doctor;

import org.springframework.web.multipart.MultipartFile;



public class DoctorCreateRequest {
    private int doctorId;
    private String name;
    private int age;
    private int specialtyCode;
    private int experienceYears;
    private String specialtyName;
    private MultipartFile image;

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSpecialtyCode() {
        return specialtyCode;
    }

    public void setSpecialtyCode(int specialtyCode) {
        this.specialtyCode = specialtyCode;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public String getSpecialtyName() {
        return specialtyName;
    }

    public void setSpecialtyName(String specialtyName) {
        this.specialtyName = specialtyName;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
