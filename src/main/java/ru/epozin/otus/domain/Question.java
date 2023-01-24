package ru.epozin.otus.domain;

import com.opencsv.bean.CsvBindByPosition;
import java.util.List;

public class Question {
  private final String questionText;
  private final Integer questionNumber;


  public Question(String questionText, Integer questionNumber) {
    this.questionText = questionText;
    this.questionNumber = questionNumber;
  }

  public String getQuestionText() {
    return questionText;
  }

  public Integer getQuestionNumber() {
    return questionNumber;
  }

}
