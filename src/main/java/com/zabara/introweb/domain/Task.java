package com.zabara.introweb.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Yaroslav_Zabara on 5/30/2014.
 */
public class Task implements Serializable{

	private Long id;
	private String question;
    private List<String> variants;
    private Integer answerIndex;
    private Contact owner;

    public Task() {
    }

    public Task(long id, String question, List<String> variants, int answerIndex, Contact owner) {
        this.id = id;
        this.question = question;
        this.variants = variants;
        this.answerIndex = answerIndex;
        this.owner = owner;
    }

    public boolean isCorrectTask() {
        return !this.getQuestion().isEmpty() && this.getOwner() != null &&
                this.getVariants().size() > 1 && this.getAnswerIndex() >= 0 &&
                this.getAnswerIndex() < this.getVariants().size();
    }

    public Contact getOwner() {
        return owner;
    }

    public void setOwner(Contact owner) {
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getVariants() {
        return variants;
    }

    public void setVariants(List<String> variants) {
        this.variants = variants;
    }

    public Integer getAnswerIndex() {
        return answerIndex;
    }

    public void setAnswerIndex(Integer answerIndex) {
        this.answerIndex = answerIndex;
    }
}
