package ru.epozin.otus.quiz;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class QuizApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(QuizApplication.class).headless(false).run(args);
    }

}
