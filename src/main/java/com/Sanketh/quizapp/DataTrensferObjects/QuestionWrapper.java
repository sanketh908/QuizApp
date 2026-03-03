package com.Sanketh.quizapp.DataTrensferObjects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class QuestionWrapper {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String questionText;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String difficultyLevel;
    private String category;


    public QuestionWrapper(int id, String questionText, String optionA, String optionB
            , String optionC, String optionD, String difficultyLevel, String category) {
        this.id = id;
        this.questionText = questionText;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.difficultyLevel = difficultyLevel;
        this.category = category;


    }


    public QuestionWrapper() {

    }
}
