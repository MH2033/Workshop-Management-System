package com.project.workshopmanagment.entity.form;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String answer;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable=false)
    private Date created;

    @NotNull(message = "Respondable cannot be null")
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "respondable_id")
    private Respondable respondable;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "question_id")
    private Question question;

    public Answer() {
    }

    public Answer(Long id, String answer, Date created, Respondable respondable, Question question) {
        this.id = id;
        this.answer = answer;
        this.created = created;
        this.respondable = respondable;
        this.question = question;
    }

    public Long getId() {
        return id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Respondable getRespondable() {
        return respondable;
    }

    public void setRespondable(Respondable respondable) {
        this.respondable = respondable;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
