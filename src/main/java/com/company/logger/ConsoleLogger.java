package com.company.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConsoleLogger implements Logger {

    private final DateTimeFormatter pattern;

    public ConsoleLogger(String dateTimeFormat) {
        pattern = DateTimeFormatter.ofPattern(dateTimeFormat);
    }

    @Override
    public void info(String message) {
        System.out.println(getDate() + " INFO: " + message);
    }

    @Override
    public void error(String message) {
        System.err.println(getDate() + " ERROR: " + message);
    }

    private String getDate() {
        LocalDateTime localDate = LocalDateTime.now();
        return pattern.format(localDate);
    }
}