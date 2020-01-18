package com.project.workshopmanagment.entity.form;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class MultipleChoiceQuestions extends Question {

    @NotBlank(message = "Question cannot be empty")
    private String question;

    @NotNull(message = "Choices cannot be empty")
    @ElementCollection
    private List<String> choices;

    public MultipleChoiceQuestions() {
    }

    public MultipleChoiceQuestions(String question, List<String> choices) {
        this.question = question;
        this.choices = choices;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getChoices() {
        return choices;
    }

    public void setChoices(List<String> choices) {
        this.choices = choices;
    }
}
