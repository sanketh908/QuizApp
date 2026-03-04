package com.Sanketh.quizapp.Repository;

import com.Sanketh.quizapp.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    public User findByUsernameIgnoreCase(String username);
}
