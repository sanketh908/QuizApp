package com.Sanketh.quizapp.Controller;

import com.Sanketh.quizapp.Repository.QuizRepository;
import com.Sanketh.quizapp.Service.QuizService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("quiz")
public class QuizController {
    private final QuizService quizService;


    public QuizController(QuizRepository quizRepository, QuizService quizService) {
        this.quizService = quizService;

    }

    @PostMapping("create")
    public ResponseEntity<ResponseEntity<String>> createQuiz(@RequestBody String category,
                                             @RequestParam int numQ,
                                             @RequestParam String title) {
            return new ResponseEntity<>(quizService.createQuiz(category,numQ,title), HttpStatus.CREATED);

    }
}
