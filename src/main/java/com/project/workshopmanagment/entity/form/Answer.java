package com.project.workshopmanagment.entity.form;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
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

    @OneToOne(cascade = CascadeType.MERGE, mappedBy = "answer")
    private Respondable respondable;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "question_id")
    private Question question;
}
