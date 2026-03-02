package com.Sanketh.quizapp.Service;

import com.Sanketh.quizapp.Entity.Question;
import com.Sanketh.quizapp.Repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionsService {
  private final QuestionRepository questionRepository;

    public QuestionsService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> getQuestions() {
      return questionRepository.findAll();
  }

  public List<Question> getQuestionsByCategory() {
  }
}
