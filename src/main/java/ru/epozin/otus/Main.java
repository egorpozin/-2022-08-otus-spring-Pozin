package ru.epozin.otus;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.epozin.otus.service.QuestionsService;

public class Main {

  public static void main(String[] args) {

    ClassPathXmlApplicationContext context =
        new ClassPathXmlApplicationContext("/spring-context.xml");
    QuestionsService service = context.getBean(QuestionsService.class);
    service.doJob();
  }
}
