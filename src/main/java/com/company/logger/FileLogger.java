package com.company.logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger implements Logger {

    private final DateTimeFormatter formatter;
    private PrintWriter printWriter;

    public FileLogger(File file, String dateTimeFormat) {

        try (FileWriter fileWriter = new FileWriter(file, true)) {

            this.printWriter = new PrintWriter(fileWriter, true);

        } catch (IOException e) {
            e.printStackTrace();
        }

        formatter = DateTimeFormatter.ofPattern(dateTimeFormat);
    }

    @Override
    public void info(String message) {
        printWriter.println(getDate() + " INFO: " + message);
    }

    @Override
    public void error(String message) {
        printWriter.println(getDate() + " ERROR: " + message);
    }

    private String getDate() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return formatter.format(localDateTime);
    }
}