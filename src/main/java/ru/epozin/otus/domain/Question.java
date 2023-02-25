package ru.epozin.otus.domain;

import com.opencsv.bean.CsvBindByPosition;
import java.util.List;

public class Question {
  private final String questionText;
  private final Integer questionNumber;
  private final List<String> options;


  public Question(String questionText, Integer questionNumber, List<String> options) {
    this.questionText = questionText;
    this.questionNumber = questionNumber;
    this.options = options;
  }

  public String getQuestionText() {
    return questionText;
  }

  public Integer getQuestionNumber() {
    return questionNumber;
  }

  public List<String> getOptions() {return options;}

}
