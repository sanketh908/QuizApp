package com.Sanketh.quizapp.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/questions")
public class QuestionCountroller  {
    @GetMapping("/getall")
    public String getAllQuestions() {
        return "This will return all questions";
    }
}
