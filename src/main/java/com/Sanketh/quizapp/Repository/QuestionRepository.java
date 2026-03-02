package com.Sanketh.quizapp.Repository;

import com.Sanketh.quizapp.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer> {


    List<Question> findAllByCategory(String category);
    List<Question> findAllByDifficulty(String difficulty);
}
