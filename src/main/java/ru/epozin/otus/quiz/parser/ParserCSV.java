package ru.epozin.otus.quiz.parser;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import ru.epozin.otus.quiz.config.CsvConfig;
import ru.epozin.otus.quiz.dao.QuestionsDaoSimple;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
@EnableConfigurationProperties(CsvConfig.class)
public class ParserCSV implements Parser {
    private final String resourcePath;
    private final char separator;
    private final Integer skipLines;

    public ParserCSV(CsvConfig csvConfig) {
        this.resourcePath = csvConfig.getResourcePath();
        this.separator = csvConfig.getSeparator();
        this.skipLines = csvConfig.getSkipLines();
    }

    public List<String[]> parseQuestions() {
        List<String[]> questions = new ArrayList<>();
        CSVReader reader =
                new CSVReaderBuilder(
                        new InputStreamReader(
                                Objects.requireNonNull(
                                        QuestionsDaoSimple.class
                                                .getClassLoader()
                                                .getResourceAsStream(resourcePath))))
                        .withSkipLines(skipLines)
                        .withCSVParser(new CSVParserBuilder().withSeparator(separator).build())
                        .build();
        try {
            questions = reader.readAll();
        } catch (IOException | CsvException e) {
            System.out.println(e.getMessage());
        }

        return questions;
    }
}
