DROP DATABASE IF EXISTS spring_test;
CREATE DATABASE spring_test; # spring_test 스키마 생성
USE spring_test; # spring_test 스키마 사용

CREATE TABLE specialty (# specialty라는 이름의 테이블 생성. 컬럼은 아래와같이 이루어져있다.
    specialty_code INT PRIMARY KEY, # 기본키. int형태의 specialty_code 컬럼
    specialty_name VARCHAR(100) NOT NULL  # 주로 텍스트를 입력받는 varchar형태로, 100자까지 허용되는 specialty_name컬럼. null을 허용하지 않는다.
);

CREATE TABLE doctor ( # doctor라는 이름의 테이블 생성. 컬럼은 아래와 같이 이루어져있다.
    doctor_id INT PRIMARY KEY, # 기본키. int형태의 doctor_id 컬럼
    name VARCHAR(100) NOT NULL, # 주로 텍스트를 입력받는 varchar형태로, 100자까지 허용되는 name컬럼. null을 허용하지 않는다.
    age INT NOT NULL, # int형태의 age 컬럼. null을 허용하지 않는다.
    specialty_code INT, # int형태의 specialty_code 컬럼.
    experience_years INT, # int형태의 experience_years 컬럼.
    FOREIGN KEY (specialty_code) REFERENCES specialty(specialty_code) # 외래키 컬럼이며, specialty_code로 이름을 짓는다. specialty 테이블의 specialty_code(기본키)를 참조한다.
);

# specialty 테이블의 컬럼(specialty_code, specialty_name)별로 값(101, "심장내과")을 할당한 새로운 열 1행을 삽입합니다.
insert into specialty(specialty_code, specialty_name) values(101, "심장내과"); 

# doctor 테이블의 컬럼(doctor_id, name, age, specialty_code, experience_years)별로 값(1,"정지안",30,101,5)을 할당한 새로운 열 1행을 삽입합니다.
insert into doctor(doctor_id, name, age, specialty_code, experience_years) values(1,"정지안",30,101,5);

alter table doctor modify column doctor_id int auto_increment;

