package com.Sanketh.quizapp.Controller;

import com.Sanketh.quizapp.Entity.Question;
import com.Sanketh.quizapp.Service.QuestionsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/questions")
public class QuestionCountroller  {
    private final QuestionsService quetionsService;

    public QuestionCountroller(QuestionsService quetionsService) {
        this.quetionsService = quetionsService;
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(quetionsService.getQuestions(), HttpStatus.OK);
        }
        catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category)
    {
        try {
            return new ResponseEntity<>(quetionsService.getQuestionsByCategory(category), HttpStatus.OK);
        }catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("difficulty/{difficulty}")
    public ResponseEntity<List<Question>> getQuestionsByDifficulty(@PathVariable String difficulty)
    {
        try{
        return  new ResponseEntity<>(quetionsService.getQuestionsByDifficulty(difficulty), HttpStatus.OK);
    }
    catch (Exception e) {
        log.error(e.getMessage());
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    }
    @PostMapping("/add")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
        try {
            return new ResponseEntity<>(quetionsService.addQuestion(question), HttpStatus.CREATED);
        }
    catch (Exception e) {
        log.error(e.getMessage());
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }
}
