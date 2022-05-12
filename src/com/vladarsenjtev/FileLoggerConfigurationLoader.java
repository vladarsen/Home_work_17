package com.vladarsenjtev;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLoggerConfigurationLoader {

    public FileLoggerConfiguration load(LoggingLevel loggingLevel, int sizeMax, String format) throws Exception {
        Date date = new Date();
        SimpleDateFormat dateFormat;
        dateFormat = new SimpleDateFormat("hh.mm.ss_dd.yyyy");
        File file = new File("Log_" + dateFormat.format(date) + format);
        file.createNewFile();
        FileLoggerConfiguration fileLoggerConfiguration = new FileLoggerConfiguration(file, loggingLevel, sizeMax, format);
        return new FileLoggerConfiguration(file, loggingLevel, sizeMax, format);
    }
}