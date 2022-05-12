package com.vladarsenjtev;

import java.io.*;
import java.util.Date;


public class FileLogger {

    public void debug(String conf, LoggingLevel loggingLevel) throws Exception {
        Date date = new Date();
        FileLoggerConfigurationLoader fileLoggerConfigurationLoader = new FileLoggerConfigurationLoader();
        FileLoggerConfiguration file = fileLoggerConfigurationLoader.load(loggingLevel, 100, ".txt");

        if (file.getFileSizeKiloBytes() <= file.getSizeMax()) {
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
            debug(conf, loggingLevel);
        }
    }


    public void info(String conf, LoggingLevel loggingLevel) throws Exception {
        Date date = new Date();
        if (loggingLevel == LoggingLevel.INFO) {
            FileLoggerConfigurationLoader fileLoggerConfigurationLoader = new FileLoggerConfigurationLoader();
            FileLoggerConfiguration file = fileLoggerConfigurationLoader.load(loggingLevel, 100, ".txt");

            if (file.getFileSizeKiloBytes() <= file.getSizeMax()) {
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
                info(conf, loggingLevel);
            }
        }
    }
}