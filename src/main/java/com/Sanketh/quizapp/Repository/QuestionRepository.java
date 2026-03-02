package com.Sanketh.quizapp.Repository;

import com.Sanketh.quizapp.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Integer> {

}
