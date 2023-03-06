package ru.epozin.otus.quiz.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "csv")
public class CsvConfig {

    private String resourcePath;
    private char separator;
    private Integer skipLines;


}
