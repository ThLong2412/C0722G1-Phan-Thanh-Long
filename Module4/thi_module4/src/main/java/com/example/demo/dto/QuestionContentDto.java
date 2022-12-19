package com.example.demo.dto;

import com.example.demo.model.QuestionType;
import com.example.demo.model.Status;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class QuestionContentDto implements Validator {
    private Long id;
    @NotEmpty(message = "Tiêu đề không được để trống")
    @Size(min = 5, max = 100, message = "Tiêu đề phải 5 đến 100 ký tự")
    private String title;
    @NotEmpty(message = "Nội dung không được để trống")
    @Size(min = 10, max = 500, message = "Tiêu đề phải 10 đến 500 ký tự")
    private String content;
    private String answer;

    @ManyToOne
    private QuestionType questionType;
    @NotEmpty(message = "Ngày tạo không được để trống")
    private String date_create;

    @ManyToOne
    private Status status;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }

    public QuestionContentDto() {
    }

    public QuestionContentDto(Long id, @NotEmpty(message = "Tiêu đề không được để trống") @Size(min = 5, max = 100, message = "Tiêu đề phải 5 đến 100 ký tự") String title, @NotEmpty(message = "Nội dung không được để trống") @Size(min = 10, max = 500, message = "Tiêu đề phải 10 đến 500 ký tự") String content, String answer, @NotEmpty(message = "Loại câu hỏi không được để trống") QuestionType questionType, @NotEmpty(message = "Ngày tạo không được để trống") String date_create, @NotEmpty(message = "Trạng thái không được để trống") Status status) {
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
