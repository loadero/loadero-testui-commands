package com.loadero.testui.commands;

import java.util.Map;

public class EmailMessage {

    private String from;
    private String subject;
    private Map<String, String> headers;
    private String textPlain;
    private String textHtml;

    public EmailMessage(String from, String subject, Map<String, String> headers, String textPlain, String textHtml) {
        this.from = from;
        this.subject = subject;
        this.headers = headers;
        this.textPlain = textPlain;
        this.textHtml = textHtml;
    }

    public String getFrom() {
        return from;
    }

    public String getSubject() {
        return subject;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getTextPlain() {
        return textPlain;
    }

    public String getTextHtml() {
        return textHtml;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public void setTextPlain(String textPlain) {
        this.textPlain = textPlain;
    }

    public void setTextHtml(String textHtml) {
        this.textHtml = textHtml;
    }
}
