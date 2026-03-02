package com.Sanketh.quizapp.Controller;

import com.Sanketh.quizapp.Entity.Question;
import com.Sanketh.quizapp.Service.QuestionsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionCountroller  {
    private final QuestionsService quetionsService;

    public QuestionCountroller(QuestionsService quetionsService) {
        this.quetionsService = quetionsService;
    }

    @GetMapping("/getall")
    public List<Question> getAllQuestions() {
        return quetionsService.getQuestions();
    }
    @GetMapping("category/{category}")
    public List<Question> getQuestionsByCategory(@PathVariable String category)
    {
        return quetionsService.getQuestionsByCategory(category);
    }
    @PostMapping("/add")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
        return new ResponseEntity<>(quetionsService.addQuestion(question), HttpStatus.CREATED);
    }
}
