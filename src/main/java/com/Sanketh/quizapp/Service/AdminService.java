package com.Sanketh.quizapp.Service;

import com.Sanketh.quizapp.Entity.User;
import com.Sanketh.quizapp.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AdminService {
    public final UserRepository userRepository;

    public AdminService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addAdmin(User user)
    {
        user.setRole("ADMIN");
       return userRepository.save(user);
    }


    public User findByUsername(String username) {
        return userRepository.findByUsernameIgnoreCase(username);
    }
    public User findById(Integer id) {
        Optional<User> user= userRepository.findById(id);
        return user.get();
    }
    public void deleteuser(Integer id) {
        userRepository.deleteById(id);
    }
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
