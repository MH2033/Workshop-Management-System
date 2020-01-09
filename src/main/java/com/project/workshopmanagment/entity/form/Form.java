package com.project.workshopmanagment.entity.form;

import com.project.workshopmanagment.entity.workshop.OfferedWorkshop;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Form {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "form")
    List<Question> questionList;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "offeredWorkshop_id")
    private OfferedWorkshop offeredWorkshop;

    public Form() {
    }

    public Form(Long id, @NotBlank String title, String description, List<Question> questionList, OfferedWorkshop offeredWorkshop) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.questionList = questionList;
        this.offeredWorkshop = offeredWorkshop;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public OfferedWorkshop getOfferedWorkshop() {
        return offeredWorkshop;
    }

    public void setOfferedWorkshop(OfferedWorkshop offeredWorkshop) {
        this.offeredWorkshop = offeredWorkshop;
    }
}
