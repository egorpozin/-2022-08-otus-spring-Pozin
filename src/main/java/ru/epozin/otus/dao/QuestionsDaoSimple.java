package ru.epozin.otus.dao;

import com.opencsv.bean.CsvBindByPosition;
import java.util.ArrayList;
import java.util.List;
import ru.epozin.otus.domain.Question;

public class QuestionsDaoSimple implements QuestionsDao {

  public List<Question> questions;

  @Override
  public Question getQuestionByNumber(int questionNumber) {
    return questions.get(questionNumber);
  }

  public void setQuestions(List<Question> questions) {
    this.questions = questions;
  }
}
