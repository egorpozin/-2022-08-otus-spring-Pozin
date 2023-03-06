package ru.epozin.otus.dao;

import ru.epozin.otus.domain.Question;

import java.util.List;

public interface QuestionsDao {

    List<Question> getQuestions();
}
