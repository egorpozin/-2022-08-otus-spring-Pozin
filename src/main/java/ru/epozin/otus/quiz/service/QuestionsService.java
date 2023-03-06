package ru.epozin.otus.quiz.service;

import ru.epozin.otus.quiz.domain.Question;

import java.util.List;

public interface QuestionsService {
    void doQuiz();

    int quizProcess(List<Question> questionList);

    void askName();

    boolean checkAnswer(Question question, String answer);

    String getResult(Integer correctAnswers, Integer requiredAnswer);

}
