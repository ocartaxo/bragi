package br.globo.desafio.ocartaxo.logger;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ApplicationLogger {

    protected static final Logger LOGGER = LogManager.getLogger();


    public static void logError(String queueName, String msg, String cause) {
        LOGGER.error("[" + queueName.toUpperCase() + "]: " + msg + " | " + cause);
    }

    public static void logInfo(String msg) {
        LOGGER.info(msg);
    }
}
