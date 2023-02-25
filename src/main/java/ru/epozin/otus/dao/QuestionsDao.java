package ru.epozin.otus.dao;

import java.util.ArrayList;
import java.util.List;
import ru.epozin.otus.domain.Question;

public interface QuestionsDao {

  Question getQuestionByNumber(int questionNumber);
  void setQuestions(List<Question> questions);
}
