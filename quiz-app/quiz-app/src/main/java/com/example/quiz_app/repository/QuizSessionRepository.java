package com.example.quiz_app.repository;

import com.example.quiz_app.model.QuizSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizSessionRepository extends JpaRepository<QuizSession, Long> {}
