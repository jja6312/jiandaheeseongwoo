package com.ssafy.exam.jpaExample.repository;

import com.ssafy.exam.jpaExample.entity.JpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaExamRepository extends JpaRepository<JpaEntity,Long> {
}
