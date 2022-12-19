package com.example.demo.model;

import javax.persistence.*;

@Entity
public class QuestionContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String answer;

    @ManyToOne
    private QuestionType questionType;
    private String date_create;

    @ManyToOne
    private Status status;

    public QuestionContent() {
    }

    public QuestionContent(Long id, String title, String content, String answer, QuestionType questionType, String date_create, Status status) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.answer = answer;
        this.questionType = questionType;
        this.date_create = date_create;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public String getDate_create() {
        return date_create;
    }

    public void setDate_create(String date_create) {
        this.date_create = date_create;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
