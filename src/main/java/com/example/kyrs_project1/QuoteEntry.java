package com.example.kyrs_project1;

import java.util.Date;

//одна циатат, объект, который собержиться в контейнере
public class QuoteEntry {
    private int id;
    private String login;
    private String content;
    private String subject;
    private Date date;
    private String teacher;

    public QuoteEntry(int id, String login, String content, String subject, Date date, String teacher) {
        this.id = id;
        this.login = login;
        this.content = content;
        this.subject = subject;
        this.date = date;
        this.teacher = teacher;
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

    @Override
    public String toString() {
        return "QuoteEntry{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", content='" + content + '\'' +
                ", subject='" + subject + '\'' +
                ", date=" + date +
                ", teacher='" + teacher + '\'' +
                '}';
    }
}
