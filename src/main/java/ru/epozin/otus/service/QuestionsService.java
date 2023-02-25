package ru.epozin.otus.service;

import com.opencsv.CSVReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import ru.epozin.otus.domain.Question;

public interface QuestionsService {
  void doJob();
  void askQuestion();

}
