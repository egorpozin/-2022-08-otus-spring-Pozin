package ru.epozin.otus.quiz.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.epozin.otus.quiz.dao.QuestionsDao;
import ru.epozin.otus.quiz.domain.Question;

import java.util.List;
import java.util.Locale;

@Service
public class QuestionsServiceImpl implements QuestionsService {
    private final QuestionsDao dao;
    private final IOService io;
    private final MessageSource messageSource;
    @Value("${quiz.requiredAnswers}")
    private Integer requiredAnswers;
    @Value(("${application.locale}"))
    private Locale locale;

    public QuestionsServiceImpl(QuestionsDao dao, IOService io, MessageSource messageSource) {
        this.dao = dao;
        this.io = io;
        this.messageSource = messageSource;

    }

    @Override
    public void doQuiz() {
        askName();
        int correctAnswers = quizProcess(dao.getQuestions());
        io.out(getResult(correctAnswers, requiredAnswers));
    }

    private int quizProcess(List<Question> questionList) {
        int correctAnswers = 0;
        for (Question question : questionList) {
            io.out(messageSource.getMessage("message.question", new String[]{String.valueOf(question.getQuestionNumber())}, locale));
            io.out(question.getQuestionText());
            if (!question.getOptions().isEmpty())
                io.out(question.getOptions());
            String answer = io.readString();
            if (checkAnswer(question, answer)) {
                correctAnswers++;
            }
        }
        return correctAnswers;
    }

    private void askName() {
        io.out(messageSource.getMessage("message.name", null, locale));
        String name = io.readString();
        io.out(messageSource.getMessage("message.hello", new String[]{name}, locale));
        io.out(messageSource.getMessage("message.quiz", new String[]{String.valueOf(requiredAnswers)}, locale));
    }

    private boolean checkAnswer(Question question, String answer) {
        return question.getRightAnswer().equalsIgnoreCase(answer);

    }

    private String getResult(Integer correctAnswers, Integer requiredAnswer) {
        if (correctAnswers >= requiredAnswer)
            return messageSource.getMessage("message.success", new String[]{String.valueOf(correctAnswers)}, locale);
        else return messageSource.getMessage("message.failure", new String[]{String.valueOf(correctAnswers)}, locale);
    }


}
