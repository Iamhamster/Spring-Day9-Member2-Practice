package com.example.memberjpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String pw;

    private String email;

    public Member(String name, String pw, String email){
        this.name = name;
        this.pw = pw;
        this.email = email;
    }

    public void update(String name, String pw, String email){
        this.name = name;
        this.pw = pw;
        this.email = email;
    }
}
