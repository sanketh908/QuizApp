package com.Sanketh.quizapp.Repository;

import com.Sanketh.quizapp.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer> {


    List<Question> findAllByCategory(String category);
    List<Question> findAllByDifficultyLevel(String difficulty);
    @Query(value = "SELECT * FROM question q WHERE q.category = :category ORDER BY RAND() LIMIT :numQ",
            nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(
            @Param("category") String category,
            @Param("numQ") int numQ);
}
