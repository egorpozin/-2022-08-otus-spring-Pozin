package ru.epozin.otus.service;

import ru.epozin.otus.dao.QuestionsDao;

public class QuestionsServiceImpl implements QuestionsService {
  private final Parser parser;
  private final QuestionsDao dao;


  public QuestionsServiceImpl(Parser parser, QuestionsDao dao) {
    this.parser = parser;
    this.dao = dao;

  }

  public void doJob() {
    parser.parse();
    dao.setQuestions(parser.getQuestions());
    for (int i = 0; i<5; i++) {
      System.out.println("Question #" + dao.getQuestionByNumber(i).getQuestionNumber());
      System.out.println(dao.getQuestionByNumber(i).getQuestionText());
      System.out.println(dao.getQuestionByNumber(i).getOptions());
    }



    }

  public void askQuestion(){

  }

}
