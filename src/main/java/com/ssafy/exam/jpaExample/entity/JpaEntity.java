package com.ssafy.exam.jpaExample.entity;

import jakarta.persistence.*;

@Entity
public class JpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;

    public JpaEntity() {
    }

    public JpaEntity(String email) {
        this.email = email;
    }
}
