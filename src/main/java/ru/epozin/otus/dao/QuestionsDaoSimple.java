package ru.epozin.otus.dao;

import ru.epozin.otus.domain.Question;
import ru.epozin.otus.parser.Parser;
import ru.epozin.otus.parser.ParserCSV;

import java.util.ArrayList;
import java.util.List;


public class QuestionsDaoSimple implements QuestionsDao {


    private final Parser parserCSV;

    public QuestionsDaoSimple(ParserCSV parserCSV) {
        this.parserCSV = parserCSV;
    }

    public List<Question> getQuestions() {
        List<Question> questionsList = new ArrayList<>();
        List<String[]> questions = parserCSV.parseQuestions();
        for (String[] row : questions) {
            Question question = new Question(row[1], Integer.parseInt(row[0]), row[2], row[3]);
            questionsList.add(question);
        }

        return questionsList;
    }
}
