package com.project.workshopmanagment.entity.form;

import javax.persistence.Entity;

@Entity
public class DescriptiveQuestion extends Question {
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
