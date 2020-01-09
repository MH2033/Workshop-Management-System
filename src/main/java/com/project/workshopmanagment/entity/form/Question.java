package com.project.workshopmanagment.entity.form;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "form_id")
    private Form form;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
    List<Answer> answerList;
}
