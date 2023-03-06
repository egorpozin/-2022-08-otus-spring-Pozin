package ru.epozin.otus.parser;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import ru.epozin.otus.dao.QuestionsDaoSimple;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ParserCSV implements Parser {


    public List<String[]> parseQuestions() {
        List<String[]> questions = new ArrayList<>();
        CSVReader reader =
                new CSVReaderBuilder(
                        new InputStreamReader(
                                Objects.requireNonNull(
                                        QuestionsDaoSimple.class
                                                .getClassLoader()
                                                .getResourceAsStream("questions.csv"))))
                        .withSkipLines(1)
                        .withCSVParser(new CSVParserBuilder().withSeparator(':').build())
                        .build();
        try {
            questions = reader.readAll();
        } catch (IOException | CsvException e) {
            System.out.println(e.getMessage());
        }

        return questions;
    }
}
