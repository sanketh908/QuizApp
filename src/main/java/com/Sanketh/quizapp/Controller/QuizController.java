package com.Sanketh.quizapp.Controller;

import com.Sanketh.quizapp.Entity.Question;
import com.Sanketh.quizapp.Entity.QuestionWrapper;
import com.Sanketh.quizapp.Repository.QuizRepository;
import com.Sanketh.quizapp.Service.QuizService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("quiz")
public class QuizController {
    private final QuizService quizService;


    public QuizController(QuizRepository quizRepository, QuizService quizService) {
        this.quizService = quizService;

    }

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,
                                             @RequestParam int numQ,
                                             @RequestParam String title) {
        try {
            quizService.createQuiz(category, numQ, title);
            return new ResponseEntity<>("done", HttpStatus.CREATED);
        }
        catch (Exception e) {
            log.error("error while creating quiz");
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        }



    }
    @PostMapping("/submit/{id}")
    public ResponseEntity<Integer> submitQuize(@PathVariable Integer id,@RequestBody Response)
    {

    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable Integer id) {
       return quizService.getQuizQuestions(id);
    }
}
