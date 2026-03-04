package com.Sanketh.quizapp.Controller;

import com.Sanketh.quizapp.Entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")

public class UserCountroller {
    UserS
    @PostMapping("/adduser")
    public String addUser(@RequestBody User user) {
        user.setRole("USER");

    }

}
