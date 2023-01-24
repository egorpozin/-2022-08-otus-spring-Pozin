package ru.epozin.otus.dao;

import java.util.List;
import ru.epozin.otus.domain.Question;

public interface QuestionsDao {

  Question getQuestionByNumber(Integer questionNumber);
}
