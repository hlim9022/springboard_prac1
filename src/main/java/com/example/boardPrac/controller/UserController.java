package com.example.boardPrac.controller;

import com.example.boardPrac.entity.User;
import com.example.boardPrac.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/login")
    public String login() {
        return "/account/login";
    }

    @PostMapping("/login")
    public String loginDone() {
        return "/board/list";
    }

    @GetMapping("/register")
    public String register() {
        return "/account/register";
    }

    @PostMapping("/register")
    public String register(User user) {
        userService.save(user);
        return "redirect:/board/list";
    }

}
