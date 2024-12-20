package com.example.quiz_app.repository;

import com.example.quiz_app.model.Submission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {}
