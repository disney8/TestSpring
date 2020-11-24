package com.proyecto.util;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Demo {
    private static boolean logToFile;
    private static boolean logToConsole;
    private static boolean logMessage;
    private static boolean logWarning;
    private static boolean logError;
    private static boolean logToDatabase;
    private boolean initialized;
    private static Map dbParams;
    private static Logger logger;

    public Demo(boolean logToFileParam, boolean logToConsoleParam, boolean logToDatabaseParam,
                boolean logMessageParam, boolean logWarningParam, boolean logErrorParam, Map dbParamsMap) {
        logger = Logger.getLogger("MyLog");
        logError = logErrorParam;
        logMessage = logMessageParam;
        logWarning = logWarningParam;
        logToDatabase = logToDatabaseParam;
        logToFile = logToFileParam;
        logToConsole = logToConsoleParam;
        dbParams = dbParamsMap;
    }

    public static void LogMessage(String messageText, boolean message, boolean warning, boolean error) throws Exception {
        messageText.trim();
        if (messageText == null || messageText.length() == 0) {
            return;
        }
        if (!logToConsole && !logToFile && !logToDatabase) {
            throw new Exception("Invalid configuration");
        }
        if ((!logError && !logMessage && !logWarning) || (!message && !warning && !error)) {
            throw new Exception("Error or Warning or Message must be specified");
        }

        Connection connection = null;
        Properties connectionProps = new Properties();
        // VAlidar que dbParams no sea null
        connectionProps.put("user", dbParams.get("userName"));
        connectionProps.put("password", dbParams.get("password"));
        
        int t = 0;
        if (message && logMessage) {
            t = 1;
        }

        if (error && logError) {
            t = 2;
        }

        if (warning && logWarning) {
            t = 3;
        }
        
         // falta el nombre de la BD y falta un try catch
        try { // new
        connection = DriverManager.getConnection("jdbc:" + dbParams.get("dbms") + "://" + dbParams.get("serverName")
        + ":" + dbParams.get("portNumber") + "/", connectionProps);       
             } catch (SQLException e) { //new
        	new Exception("Invalid configuration");// new
        }
        
        String l = null;
        File logFile = new File(dbParams.get("logFileFolder") + "/logFile.txt"); // la carpeta debe ser la que hay ahi del path
        if (!logFile.exists()) {
            logFile.createNewFile();
        }

        FileHandler fh = new FileHandler(dbParams.get("logFileFolder") + "/logFile.txt");
        ConsoleHandler ch = new ConsoleHandler();

        if (error && logError) {
            l = l + "error " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + messageText;
        }

        if (warning && logWarning) {
            l = l + "warning " +DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + messageText;
        }

        if (message && logMessage) {
            l = l + "message " +DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + messageText;
        }

        if(logToFile) {
            logger.addHandler(fh);
            logger.log(Level.INFO, messageText);
        }

        if(logToConsole) {
            logger.addHandler(ch);
            logger.log(Level.INFO, messageText);
        }

        if(logToDatabase) {
            Statement stmt = connection.createStatement(); // afuera da un null pointer
            stmt.executeUpdate("insert into Log_Values('" + message + "', " + String.valueOf(t) + ")");          
        }
    }
}
