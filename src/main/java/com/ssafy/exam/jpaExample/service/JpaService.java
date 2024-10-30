package com.ssafy.exam.jpaExample.service;

import com.ssafy.exam.jpaExample.entity.JpaEntity;
import com.ssafy.exam.jpaExample.repository.JpaExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JpaService {
    @Autowired
    JpaExamRepository jpaExamRepository;

    public void go(){
        JpaEntity jpaEntity = new JpaEntity("jja6312@naver.com");

        jpaExamRepository.save(jpaEntity);
    }


}
