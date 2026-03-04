package com.Sanketh.quizapp.Controller;

import com.Sanketh.quizapp.Entity.User;
import com.Sanketh.quizapp.Repository.UserRepository;
import com.Sanketh.quizapp.Service.AdminService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController
{
   private final AdminService adminService;
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }
@PostMapping("/add")
    public User addAdmin(User user)
    {
        return adminService.addAdmin(user);
    }

}
