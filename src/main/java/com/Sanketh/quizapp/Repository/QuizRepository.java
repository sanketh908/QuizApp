package com.Sanketh.quizapp.Repository;

import com.Sanketh.quizapp.Entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {
}
