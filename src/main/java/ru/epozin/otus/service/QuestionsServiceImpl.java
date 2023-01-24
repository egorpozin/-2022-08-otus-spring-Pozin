package ru.epozin.otus.service;

import com.opencsv.bean.CsvToBeanBuilder;
import java.io.InputStreamReader;
import java.util.List;
import ru.epozin.otus.dao.QuestionsDao;
import ru.epozin.otus.dao.QuestionsDaoSimple;
import ru.epozin.otus.domain.Question;

public class QuestionsServiceImpl implements QuestionsService {

  private String resourcePath;

  private QuestionsDao dao;

  public QuestionsServiceImpl(QuestionsDao dao) {
    this.dao = dao;
  }

  @Override
  public Question getQuestion(Integer questionNumber) {
    return dao.getQuestionByNumber(questionNumber);
  }

  public void setQuestionParams() {
    List<QuestionsDaoSimple> questions =
        new CsvToBeanBuilder(
                new InputStreamReader(QuestionsService.class.getResourceAsStream(resourcePath)))
            .withType(QuestionsDao.class)
            .build()
            .parse();
    for(int i = 0; i<questions.size(); i++){
      QuestionsDao question = new QuestionsDaoSimple();
    }
  }

  public void setQuestionsParams(){

  }

  public void setResourcePath(String resourcePath) {
    this.resourcePath = resourcePath;
  }
}
