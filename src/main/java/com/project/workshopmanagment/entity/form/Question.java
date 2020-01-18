package com.project.workshopmanagment.entity.form;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @NotNull(message = "Form cannot be empty")
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "form_id")
    protected Form form;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
    List<Answer> answerList;

    public Question() {
    }

    public Question(Long id, Form form, List<Answer> answerList) {
        this.id = id;
        this.form = form;
        this.answerList = answerList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }
}
