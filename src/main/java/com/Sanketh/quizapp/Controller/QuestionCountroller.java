package com.Sanketh.quizapp.Controller;

import com.Sanketh.quizapp.Entity.Question;
import com.Sanketh.quizapp.Service.QuestionsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/{catogary}")
    public List<Question> getQuestionsByCatogary(@PathVariable String catogary)
    {
        return quetionsService.getQuestionsByCategory()
    }
}
