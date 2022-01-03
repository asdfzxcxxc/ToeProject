package com.example.movie.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.example.movie.Repository.SignUpRepository;
import com.example.movie.model.SignUp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    @Autowired
    SignUpRepository signUpRepository;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginpost(SignUp signup, HttpSession session) {
        SignUp result = signUpRepository.findByUserIdAndUserPw(signup.getUserId(), signup.getUserPw());
        if (result != null) {
            session.setAttribute("signup", signup);
        } else {
            System.out.println("오 류");
        }
        return "redirect:/home";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signupPost(SignUp signup, HttpSession session) {
        session.setAttribute("signup", signup);
        signUpRepository.save(signup);
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate(); // 세션 날림
        }
        return "redirect:/home";
    }
}
