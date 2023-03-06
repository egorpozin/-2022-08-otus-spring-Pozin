package ru.epozin.otus.domain;

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

    public String getQuestionText() {
        return questionText;
    }

    public Integer getQuestionNumber() {
        return questionNumber;
    }

    public String getOptions() {
        return options;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }
}
