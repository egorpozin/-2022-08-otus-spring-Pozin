package ru.epozin.otus.service;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import ru.epozin.otus.domain.Question;

public class ParserCSVImpl implements Parser{
  private List<Question> questionsList = new ArrayList<>();
  public void parse(){
    List<String[]> questions;
    CSVReader reader = new CSVReader(new InputStreamReader(Objects.requireNonNull(ParserCSVImpl.class.getClassLoader().getResourceAsStream("questions.csv"))));
    try{
    questions = reader.readAll();
    for (String[] row: questions){
      Question question = new Question(row[1],Integer.parseInt(row[0]), Collections.singletonList(row[2]));
      //Answer answer = new Answer(row[2],Integer.parseInt(row[0]));
      questionsList.add(question);
      //answerList.add(answer);
    }

    } catch (IOException | CsvException e){
      System.out.println(e.getMessage());
    }
  }

  public List getQuestions() {
    return questionsList;
  }

  //public List getAnswers() {
   // return answerList;
  //}

}
