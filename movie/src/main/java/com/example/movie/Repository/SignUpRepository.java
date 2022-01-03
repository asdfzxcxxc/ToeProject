package com.example.movie.Repository;

import com.example.movie.model.SignUp;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SignUpRepository extends JpaRepository<SignUp, String> {
    SignUp findByUserIdAndUserPw(String userId, String userPw); //유저의 
}
