package ru.epozin.otus.quiz.shell;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import ru.epozin.otus.quiz.service.IOService;
import ru.epozin.otus.quiz.service.QuestionsService;

import java.util.Locale;

@ShellComponent
public class ShellCommands {
    private final QuestionsService questionsService;
    private final IOService ioService;
    private final MessageSource messageSource;
    @Value(("${application.locale}"))
    private Locale locale;

    private boolean helloSaid;
    public ShellCommands(QuestionsService questionsService, IOService ioService, MessageSource messageSource) {
        this.questionsService = questionsService;
        this.ioService = ioService;
        this.messageSource = messageSource;
    }

    @ShellMethod
    @ShellMethodAvailability(value ="isStartQuizAvailable")
    public String run(){
        questionsService.doQuiz();
        return messageSource.getMessage("message.end",null,locale);
    }
    @ShellMethod
    public String greetings(){
        helloSaid = ioService.readString().isEmpty();
        if (!helloSaid){
            return "(*¯︶¯*)";
        } else return "¯\\_(ツ)_/¯";

    }

    private Availability isStartQuizAvailable() {
        return helloSaid ? Availability.unavailable(messageSource.getMessage("message.reason", null, locale)): Availability.available();
    }
}
