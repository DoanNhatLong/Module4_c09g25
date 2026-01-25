package com.example.ss1_spring_mvc.entity;

public class Email {
    String language;
    int page;
    boolean spam;
    String desc;

    public Email() {
    }

    public Email(String language, int page, boolean spam, String desc) {
        this.language = language;
        this.page = page;
        this.spam = spam;
        this.desc = desc;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public boolean isSpam() {
        return spam;
    }

    public void setSpam(boolean spam) {
        this.spam = spam;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Email{" +
                "language='" + language + '\'' +
                ", page=" + page +
                ", spam=" + spam +
                ", desc='" + desc + '\'' +
                '}';
    }
}
