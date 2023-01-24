package ru.epozin.otus;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.epozin.otus.dao.QuestionsDao;
import ru.epozin.otus.domain.Question;
import ru.epozin.otus.service.QuestionsService;

public class Main {

  public static void main(String[] args) {

    ClassPathXmlApplicationContext context =
        new ClassPathXmlApplicationContext("/spring-context.xml");
    QuestionsService service = context.getBean(QuestionsService.class);
    for(int i = 0; i<5; i++){
    Question question = service.getQuestion(i);
      System.out.println(question);
        }
  }

}
