package com.Sanketh.quizapp.Service;

import com.Sanketh.quizapp.Entity.User;
import com.Sanketh.quizapp.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
   private final UserRepository userRepository;
   public User saveUser(User user) {
       return userRepository.save(user);
   }

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUsername(String username) {
        return userRepository.findByUsernameIgnoreCase(username);
    }
    public User findById(Integer id) {
        Optional<User> user= userRepository.findById(id);
        return user.get();
    }
}
