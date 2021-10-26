package services;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

public class FileLogger {
    //print some or all of the stack trace to file
    //logging levels - Severe, moderate, warming, info

    private static FileLogger fileLogger;
    private static int threshold;
    private static boolean printToConsole;
    private static boolean printToConsoleTemp = false;
    private static Logger logger;

//    public enum Threshold {
//        INFO,
//        WARN,
//        MODERATE,
//        SEVERE
//    }
    private FileLogger() {
        printToConsole = false;
        printToConsoleTemp = false;
        threshold = 3;

    }

    public static FileLogger getFileLogger() {
        if(fileLogger == null) {
        fileLogger = new FileLogger();
    }
        return fileLogger;
}


    public void writeLog(String message, int level) {
        try (FileWriter fileWriter = new FileWriter(getLogFileName(), true)){
            String logEntry = formatLogEntry(message);

            if(level >= threshold) {
                fileWriter.write(logEntry);
            }

            if(printToConsole|| printToConsoleTemp) {
                System.out.println(logEntry);
                printToConsoleTemp = false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private String getLogFileName() {
        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return "C:/Users/Hawkx1/Documents/Revature-Training/Gregg-Travis-Project-1/logs/" + today + "log";
    }

    private String formatLogEntry(String message) {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String stackInfo = stackTraceElements[3].toString();
        String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        return String.format("%s [%s] %s", timeStamp, stackInfo, message);
    }

    public FileLogger console() {
        printToConsoleTemp = true;
        return fileLogger;
    }

    public FileLogger threshold(int th) {
        threshold = th;
        return fileLogger;
    }

//    private boolean checkThreshold(Threshold level) {
//
//    }
    public static boolean isPrintToConsole() {
        return printToConsole;
    }

    public static void setPrintToConsole(boolean printToConsole) {
        FileLogger.printToConsole = printToConsole;
    }


    public static int getThreshold() {
        return threshold;
    }

    public static void setThreshold(int threshold) {
        FileLogger.threshold = threshold;
    }
}
