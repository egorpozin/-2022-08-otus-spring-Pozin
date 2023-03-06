package ru.epozin.otus.quiz.domain;

import lombok.Data;

@Data
public class Question {
    private final String questionText;
    private final Integer questionNumber;
    private final String options;
    private final String rightAnswer;


    public Question(String questionText, Integer questionNumber, String options, String rightAnswer) {
        this.questionText = questionText;
        this.questionNumber = questionNumber;
        this.options = options;
        this.rightAnswer = rightAnswer;
    }
}
