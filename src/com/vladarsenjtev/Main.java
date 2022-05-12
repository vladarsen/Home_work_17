package com.vladarsenjtev;


public class Main {
    public static void main(String[] args) throws Exception {
        FileLogger fileLogger = new FileLogger();
        fileLogger.debug("Успех", LoggingLevel.DEBUG);
        fileLogger.debug("Успех", LoggingLevel.DEBUG);
        fileLogger.debug("Успех", LoggingLevel.DEBUG);
        fileLogger.debug("Успех", LoggingLevel.DEBUG);
        fileLogger.debug("Успех", LoggingLevel.INFO);
        fileLogger.debug("Успех", LoggingLevel.INFO);
    }
}
