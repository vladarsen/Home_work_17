package com.vladarsenjtev;

import java.io.File;

public class FileLoggerConfiguration {
    private File logger;
    private LoggingLevel loggingLevel;
    private int sizeMax;
    private String format;
    private String path;

    public FileLoggerConfiguration(File logger, LoggingLevel loggingLevel, int sizeMax, String format) {
        this.logger = logger;
        this.loggingLevel = loggingLevel;
        this.sizeMax = sizeMax;
        this.format = format;
    }

    public File getLogger() {
        return logger;
    }

    public double getFileSizeKiloBytes() {
        return (double) logger.length();
    }

    public String getPath() {
        return logger.getAbsolutePath();
    }

    public int getSizeMax() {
        return sizeMax;
    }
}
