package com.Sanketh.quizapp.Controller;

import com.Sanketh.quizapp.Entity.Question;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody String category,
                                             @RequestParam int numQ,
                                             @RequestParam String title) {


    }
}
