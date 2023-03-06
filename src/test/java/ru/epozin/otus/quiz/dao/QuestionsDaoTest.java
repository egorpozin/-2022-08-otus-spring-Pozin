package ru.epozin.otus.quiz.dao;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import ru.epozin.otus.quiz.domain.Question;
import ru.epozin.otus.quiz.parser.ParserCSV;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class QuestionsDaoTest {

    @Mock
    private ParserCSV parser;
    @InjectMocks
    private QuestionsDaoSimple questionsDaoSimple;

    @Test
    void testGetQuestions() {
        List<Question> questions = new ArrayList<>();
        List<String[]> rowQuestions = new ArrayList<>();
        rowQuestions.add(new String[]{"1", "Какого цвета снег?", "Белый, Зеленый, Синий", "Белый"});
        questions.add(new Question("Какого цвета снег?", 1, "Белый, Зеленый, Синий", "Белый"));
        when(parser.parseQuestions()).thenReturn(rowQuestions);
        assertEquals(questions, questionsDaoSimple.getQuestions());
    }

}
