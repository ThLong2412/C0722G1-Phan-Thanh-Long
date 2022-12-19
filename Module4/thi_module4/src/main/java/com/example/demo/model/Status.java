package com.example.demo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "status")
    public Set<QuestionContent> questionContents;

    public void setQuestionContents(Set<QuestionContent> questionContents) {
        this.questionContents = questionContents;
    }

    public Status() {
    }

    public Status(Long id, String name, Set<QuestionContent> questionContents) {
        this.id = id;
        this.name = name;
        this.questionContents = questionContents;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<QuestionContent> getQuestionContents() {
        return questionContents;
    }
}
