package com.example.quiz_app.model;

import jakarta.persistence.*;

@Entity
public class Submission {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private QuizSession session;

    @ManyToOne
    private Question question;

    private String userAnswer;
    private boolean correct;

    public Submission(QuizSession session, Question question, String userAnswer, boolean correct) {
        this.session = session;
        this.question = question;
        this.userAnswer = userAnswer;
        this.correct = correct;
    }

    // Default constructor, Getters, and Setters
}
