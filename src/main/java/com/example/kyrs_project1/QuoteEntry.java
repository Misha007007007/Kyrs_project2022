package com.example.kyrs_project1;

import java.util.Date;

//одна циатат, объект, который собержиться в контейнере
public class QuoteEntry {
    private int id;

    private String content;
    private String subject;
    private String teacher;
    private Date date;
    private String login;

    public QuoteEntry(int id, String content, String subject, String teacher, Date date, String login) {
        this.id = id;
        this.content = content;
        this.subject = subject;
        this.teacher = teacher;
        this.date = date;
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getSubject() {
        return subject;
    }

    public String getTeacher() {
        return teacher;
    }

    public Date getDate() {
        return date;
    }

    public String getLogin() {
        return login;
    }
}
