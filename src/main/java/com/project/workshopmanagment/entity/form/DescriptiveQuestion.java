package com.project.workshopmanagment.entity.form;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
public class DescriptiveQuestion extends Question {

    @NotBlank(message = "Question cannot be empty")
    private String question;

    public DescriptiveQuestion() {
    }

    public DescriptiveQuestion(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
