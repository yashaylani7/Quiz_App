package com.example.quiz_app.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class QuizSession {

    @Id
    @GeneratedValue
    private Long id;

    private String userName;
    private int correctAnswers = 0;
    private int incorrectAnswers = 0;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Question> questions;

    // Default constructor (required by JPA)
    public QuizSession() {}

    // Overloaded constructor for initializing a new quiz session
    public QuizSession(String userName, List<Question> questions) {
        this.userName = userName;
        this.questions = questions;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public int getIncorrectAnswers() {
        return incorrectAnswers;
    }

    public void setIncorrectAnswers(int incorrectAnswers) {
        this.incorrectAnswers = incorrectAnswers;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    // Increment correct answers
    public void incrementCorrectAnswers() {
        this.correctAnswers++;
    }

    // Increment incorrect answers
    public void incrementIncorrectAnswers() {
        this.incorrectAnswers++;
    }
}
