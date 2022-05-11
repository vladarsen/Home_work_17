package com.vladarsenjtev;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        FileLoggerConfigurationLoader fileLoggerConfigurationLoader = new FileLoggerConfigurationLoader();
        FileLoggerConfiguration fileLoggerConfiguration = fileLoggerConfigurationLoader.load(LoggingLevel.DEBUG, 300, ".txt");
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        while (count < 30) {
            System.out.println("Введите текст:");
            String str = scanner.next();
            FileLogger fileLogger = new FileLogger();
            try {
                fileLogger.debug(str, LoggingLevel.DEBUG, fileLoggerConfiguration);
            } catch (FileMaxSizeReachedException ex) {
                System.out.println(ex.getMessage());
                FileLoggerConfiguration fileLoggerConfigurationOne = fileLoggerConfigurationLoader.load(LoggingLevel.DEBUG, 300, ".txt");
                fileLogger.debug(str, LoggingLevel.DEBUG, fileLoggerConfigurationOne);
                count++;
            }
        }
    }
}