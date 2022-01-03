package com.example.movie.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class SignUp {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id; //회원 번호?
    private String userName; //가입 시 적을 이름
    private String userId; //로그인 시 사용할 ID
    private String userPw; //로그인 시 사용할 pW
    private String userEmail; //가입 시 인증메일을 수신할 Email 주소
    private int userCash = 50000; //예매 시 사용할 가상의 돈
    
}
