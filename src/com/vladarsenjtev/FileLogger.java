package com.vladarsenjtev;

import java.io.*;
import java.util.Date;


public class FileLogger {
    FileLoggerConfigurationLoader fileLoggerConfigurationLoader = new FileLoggerConfigurationLoader();
    Date date = new Date();


    public void debug(String conf, LoggingLevel loggingLevel, FileLoggerConfiguration file) throws Exception {


        if (file.getFileSizeKiloBytes() <= file.sizeMax) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file.getLogger(), true))) {
                writer.append(String.valueOf(date)).append(" ").append(String.valueOf(loggingLevel)).append(" ").append(conf);
                writer.newLine();
            }
            try (BufferedReader reader = new BufferedReader(new FileReader(file.getLogger()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } else {
            throw new FileMaxSizeReachedException("Превышен размер файла");
        }
    }


    public void info(String conf, LoggingLevel loggingLevel, FileLoggerConfiguration file) throws Exception {
        if (file.getFileSizeKiloBytes() <= file.sizeMax) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file.getLogger(), true))) {
                writer.append(String.valueOf(date)).append(" ").append(String.valueOf(loggingLevel)).append(" ").append(conf);
                writer.newLine();
            }
            try (BufferedReader reader = new BufferedReader(new FileReader(file.getLogger()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } else {
            throw new FileMaxSizeReachedException("Превышен размер файла");
        }
    }
}