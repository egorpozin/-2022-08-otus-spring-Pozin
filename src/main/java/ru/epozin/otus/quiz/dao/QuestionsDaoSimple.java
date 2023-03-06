package ru.epozin.otus.quiz.dao;

import org.springframework.stereotype.Component;
import ru.epozin.otus.quiz.domain.Question;
import ru.epozin.otus.quiz.parser.Parser;
import ru.epozin.otus.quiz.parser.ParserCSV;

import java.util.ArrayList;
import java.util.List;

@Component
public class QuestionsDaoSimple implements QuestionsDao {

    private final Parser parserCSV;

    public QuestionsDaoSimple(ParserCSV parserCSV) {
        this.parserCSV = parserCSV;
    }

    @Override
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
