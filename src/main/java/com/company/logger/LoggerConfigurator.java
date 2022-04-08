package com.company.logger;

import com.company.logger.util.Parser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;

public final class LoggerConfigurator {

    private static final SAXParserFactory FACTORY = SAXParserFactory.newInstance();
    private static Logger logger = null;
    private static final String FILE_NAME = "logger.xml";
    private String type;
    private String path;
    private String dateFormat;

    private LoggerConfigurator() {

        Parser parser = new Parser();

        try {
            InputStream stream = getAsStream(FILE_NAME);

            SAXParser saxParser = FACTORY.newSAXParser();
            saxParser.parse(stream, parser);
        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }

        setType(parser.getType());
        setPath(parser.getPath());
        setDateFormat(parser.getDateFormat());
    }

    public static Logger getInstance() {
        if (logger == null) {
            logger = LoggerConfigurator.getLogger();
        }

        return logger;
    }

    private static Logger getLogger() {

        if ("FILE".equalsIgnoreCase(new LoggerConfigurator().type)) {

            return new FileLogger(new File(new LoggerConfigurator().path), new LoggerConfigurator().dateFormat);

        } else if ("CONSOLE".equalsIgnoreCase(new LoggerConfigurator().type)) {

            return new ConsoleLogger(new LoggerConfigurator().dateFormat);

        } else {
            throw new IllegalArgumentException();
        }
    }

//    private File getFile(String fileName) throws URISyntaxException {
//
//        ClassLoader classLoader = getClass().getClassLoader();
//        URL url = classLoader.getResource(fileName);
//
//        if (url == null) {
//            throw new IllegalArgumentException("File not found. " + fileName);
//        }
//
//        return new File(url.toURI());
//    }

    private InputStream getAsStream(String resource){

        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(resource);

        if (inputStream == null) {
            throw new IllegalArgumentException("File not found. " + resource);
        } else {
            return inputStream;
        }
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }
}