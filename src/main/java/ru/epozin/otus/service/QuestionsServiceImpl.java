package ru.epozin.otus.service;

import ru.epozin.otus.dao.QuestionsDao;
import ru.epozin.otus.domain.Question;

import java.util.List;

public class QuestionsServiceImpl implements QuestionsService {
    private final QuestionsDao dao;


    public QuestionsServiceImpl(QuestionsDao dao) {
        this.dao = dao;

    }

    @Override
    public void doQuiz() {
        quizProcess(dao.getQuestions());
    }

    public void quizProcess(List<Question> questionList) {
        for (Question question : questionList) {
            System.out.println("Question #" + question.getQuestionNumber());
            System.out.println(question.getQuestionText());
            if (!question.getOptions().isEmpty())
                System.out.println(question.getOptions());
        }
    }

}
