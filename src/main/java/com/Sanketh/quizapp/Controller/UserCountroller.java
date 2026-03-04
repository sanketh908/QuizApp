package com.Sanketh.quizapp.Controller;

import com.Sanketh.quizapp.Entity.User;
import com.Sanketh.quizapp.Service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")

public class UserCountroller {

  private final   UserService userService;

    public UserCountroller(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/adduser")
    public User addUser(@RequestBody User user) {
        user.setRole("USER");
      return   userService.saveUser(user);

    }
    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable int id) {
       return userService.findById(id);
    }
    @GetMapping("/getUser/{username}")
    public User getUser(@PathVariable String username) {
        return userService.findByUsername(username);
    }

}
