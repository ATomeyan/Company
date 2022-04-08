package com.company.logger.util;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public final class Parser extends DefaultHandler {

    private String type = "";
    private String path = "";
    private String dateFormat = "";

    private boolean isType = false;
    private boolean isPath = false;
    private boolean isFormatter = false;

    public String getType() {
        return type;
    }

    public String getPath() {
        return path;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (qName.equalsIgnoreCase("type"))
            isType = true;
        else if (qName.equalsIgnoreCase("path"))
            isPath = true;
        else if (qName.equalsIgnoreCase("dateFormat"))
            isFormatter = true;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (isType) {
            isType = false;
        } else if (isPath) {
            isPath = false;
        } else if (isFormatter) {
            isFormatter = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isType)
            type += new String(ch, start, length).trim();
        else if (isPath)
            path += new String(ch, start, length).trim();
        else if (isFormatter)
            dateFormat += new String(ch, start, length).trim();
    }
}