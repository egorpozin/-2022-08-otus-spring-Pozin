package ru.epozin.otus.quiz;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import ru.epozin.otus.quiz.domain.Question;
import ru.epozin.otus.quiz.service.IOService;
import ru.epozin.otus.quiz.service.IOServiceImpl;
import ru.epozin.otus.quiz.service.QuestionsService;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class QuizApplicationTests {
	@Test
	void contextLoads() {
	}
}
