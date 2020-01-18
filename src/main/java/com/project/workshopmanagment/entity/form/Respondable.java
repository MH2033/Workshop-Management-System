package com.project.workshopmanagment.entity.form;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Respondable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "respondable")
    private List<Answer> answerList;


    public Respondable() {
    }

    protected Respondable(Long id, List<Answer> answer) {
        this.id = id;
        this.answerList = answer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answer) {
        this.answerList = answer;
    }
}
