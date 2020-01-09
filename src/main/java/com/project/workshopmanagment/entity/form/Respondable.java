package com.project.workshopmanagment.entity.form;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Respondable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "answer_id")
    private Answer answer;


    public Respondable() {
    }

    protected Respondable(Long id, Answer answer) {
        this.id = id;
        this.answer = answer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
