package ru.epozin.otus.quiz.dao;

import ru.epozin.otus.quiz.domain.Question;

import java.util.List;

public interface QuestionsDao {

    List<Question> getQuestions();
}
