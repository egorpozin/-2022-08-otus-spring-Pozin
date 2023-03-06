package ru.epozin.otus.quiz.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

@Service
public class IOServiceImpl implements IOService {


    private final PrintStream out;
    private final Scanner scanner;

    public IOServiceImpl(@Value("#{ T(java.lang.System).out}") PrintStream out,
                         @Value("#{ T(java.lang.System).in}") InputStream in) {
        this.out = System.out;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void out(String message) {
        out.println(message);
    }

    @Override
    public String readString() {
        return scanner.nextLine();
    }
}
