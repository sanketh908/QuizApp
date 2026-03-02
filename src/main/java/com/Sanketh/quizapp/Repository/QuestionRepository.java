package com.Sanketh.quizapp.Repository;

import com.Sanketh.quizapp.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,Integer> {


    List<Question> findAllByCategory(String category);
    List<Question> findAllByDifficulty(String difficulty);
}
