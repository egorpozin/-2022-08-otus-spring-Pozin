package ru.epozin.otus.quiz.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.epozin.otus.quiz.service.QuestionsServiceImpl;

@Configuration
public class AppConfig {
    @Bean
    public CommandLineRunner runner(QuestionsServiceImpl questionsService) {
        return args -> questionsService.doQuiz();
    }


}
