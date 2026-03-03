package com.Sanketh.quizapp.Service;

import com.Sanketh.quizapp.Entity.Question;
import com.Sanketh.quizapp.DataTrensferObjects.QuestionWrapper;
import com.Sanketh.quizapp.Entity.Quiz;
import com.Sanketh.quizapp.DataTrensferObjects.Response;
import com.Sanketh.quizapp.Repository.QuestionRepository;
import com.Sanketh.quizapp.Repository.QuizRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;

    public QuizService(QuizRepository quizRepository, QuestionRepository questionRepository) {
        this.quizRepository = quizRepository;
        this.questionRepository = questionRepository;
    }


    public Integer createQuiz(String category, int numQ, String title) {
        List<Question> questions = questionRepository.findRandomQuestionsByCategory(category,numQ);
        Quiz quiz = new Quiz();
        quiz.setQuizName(title);
        quiz.setQuestions(questions);
        quizRepository.save(quiz);
        quiz.getId();
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
       Optional<Quiz> quiz= quizRepository.findById(id);
       List<Question> question = quiz.get().getQuestions();
       List<QuestionWrapper> questionWrappers = new ArrayList<>();
       for  (Question q : question) {
           QuestionWrapper questionWrapper = new QuestionWrapper(q.getId(),q.getQuestionText(),q.getOptionA(),q.getOptionB(),q.getOptionC(),q.getOptionD(),q.getDifficultyLevel(),q.getCategory());
           questionWrappers.add(questionWrapper);
       }
       return new ResponseEntity<>(questionWrappers, HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateRessult(Integer id, List<Response> response) {
        Quiz quiz = quizRepository.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        int right =0;
        int i=0;
        for(Response r : response) {
            if(r.getResponse().equalsIgnoreCase(questions.get(i).getCorrectAnswer()))
            {
                right++;

            }
            i++;
        }
        return new ResponseEntity<>(right,HttpStatus.OK);
    }
}
