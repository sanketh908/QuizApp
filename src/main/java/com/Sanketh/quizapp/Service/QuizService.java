package com.Sanketh.quizapp.Service;

import com.Sanketh.quizapp.Entity.Question;
import com.Sanketh.quizapp.Entity.Quiz;
import com.Sanketh.quizapp.Repository.QuestionRepository;
import com.Sanketh.quizapp.Repository.QuizRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {
    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;

    public QuizService(QuizRepository quizRepository, QuestionRepository questionRepository) {
        this.quizRepository = quizRepository;
        this.questionRepository = questionRepository;
    }


    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Question> questions = questionRepository.findRandomQuestionsByCategory(category,numQ);
        Quiz quiz = new Quiz();
        quiz.setQuizName(title);
        quiz.setQuestions(questions);
        quizRepository.save(quiz);
        return new ResponseEntity<>("done ", HttpStatus.CREATED);
    }
}
