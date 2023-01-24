package ru.epozin.otus.dao;

import com.opencsv.bean.CsvBindByPosition;
import java.util.List;
import ru.epozin.otus.domain.Question;

public class QuestionsDaoSimple implements QuestionsDao {
  @CsvBindByPosition(position = 0)
  private String questionText;

  @Override
  public Question getQuestionByNumber(Integer questionNumber) {
    return new Question(questionText,questionNumber);
  }
}
