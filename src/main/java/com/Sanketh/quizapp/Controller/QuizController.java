package com.Sanketh.quizapp.Controller;

import com.Sanketh.quizapp.Repository.QuizRepository;
import com.Sanketh.quizapp.Service.QuizService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("quiz")
public class QuizController {
    private final QuizService quizService;


    public QuizController(QuizRepository quizRepository, QuizService quizService) {
        this.quizService = quizService;

    }

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody String category,
                                             @RequestParam int numQ,
                                             @RequestParam String title) {
        try {
            return new ResponseEntity<>("done", HttpStatus.CREATED);
        }
        catch (Exception e) {
            log.error("error while creating quiz");
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }
}
