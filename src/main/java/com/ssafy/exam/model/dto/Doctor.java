package com.ssafy.exam.model.dto;

public class Doctor {
    private int doctorId;
    private String name;
    private int age;
    private int specialtyCode;
    private int experienceYears;
    private String specialtyName;
    private String profileImageUrl;

    public Doctor() {
    }

    // Private constructor to allow creation only through the builder
    private Doctor(DoctorBuilder builder) {
        this.doctorId = builder.doctorId;
        this.name = builder.name;
        this.age = builder.age;
        this.specialtyCode = builder.specialtyCode;
        this.experienceYears = builder.experienceYears;
        this.specialtyName = builder.specialtyName;
        this.profileImageUrl = builder.profileImageUrl;
    }

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

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public static DoctorBuilder builder() {
        return new DoctorBuilder();
    }

    public static class DoctorBuilder {
        private int doctorId;
        private String name;
        private int age;
        private int specialtyCode;
        private int experienceYears;
        private String specialtyName;
        private String profileImageUrl;

        public DoctorBuilder doctorId(int doctorId) {
            this.doctorId = doctorId;
            return this;
        }

        public DoctorBuilder name(String name) {
            this.name = name;
            return this;
        }

        public DoctorBuilder age(int age) {
            this.age = age;
            return this;
        }

        public DoctorBuilder specialtyCode(int specialtyCode) {
            this.specialtyCode = specialtyCode;
            return this;
        }

        public DoctorBuilder experienceYears(int experienceYears) {
            this.experienceYears = experienceYears;
            return this;
        }

        public DoctorBuilder specialtyName(String specialtyName) {
            this.specialtyName = specialtyName;
            return this;
        }

        public DoctorBuilder profileImageUrl(String profileImageUrl) {
            this.profileImageUrl = profileImageUrl;
            return this;
        }

        // Build method to create an instance of Doctor
        public Doctor build() {
            return new Doctor(this);
        }
    }
}
