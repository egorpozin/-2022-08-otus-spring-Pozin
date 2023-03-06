package ru.epozin.otus.quiz.dao;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import ru.epozin.otus.quiz.config.CsvConfig;
import ru.epozin.otus.quiz.domain.Question;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
@EnableConfigurationProperties(CsvConfig.class)
public class QuestionsDaoSimple implements QuestionsDao {

    private final String resourcePath;
    private final char separator;
    private final Integer skipLines;

    public QuestionsDaoSimple(CsvConfig csvConfig) {
        this.resourcePath = csvConfig.getResourcePath();
        this.separator = csvConfig.getSeparator();
        this.skipLines = csvConfig.getSkipLines();
    }

    @Override
    public List<Question> getQuestions() {
        List<Question> questionsList = new ArrayList<>();
        List<String[]> questions;
        CSVReader reader =
                new CSVReaderBuilder(
                        new InputStreamReader(
                                Objects.requireNonNull(
                                        QuestionsDaoSimple.class
                                                .getClassLoader()
                                                .getResourceAsStream(resourcePath)))).withSkipLines(skipLines).withCSVParser(new CSVParserBuilder()
                        .withSeparator(separator)
                        .build()
                ).build();
        try {
            questions = reader.readAll();
            for (String[] row : questions) {
                Question question =
                        new Question(
                                row[1], Integer.parseInt(row[0]), row[2], row[3]);
                questionsList.add(question);
            }

        } catch (IOException | CsvException e) {
            System.out.println(e.getMessage());
        }
        return questionsList;
    }
}
