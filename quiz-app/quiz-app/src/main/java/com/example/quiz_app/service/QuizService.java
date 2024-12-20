package com.example.quiz_app.service;

import com.example.quiz_app.model.Question;
import com.example.quiz_app.model.QuizSession;
import com.example.quiz_app.repository.QuestionRepository;
import com.example.quiz_app.repository.QuizSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class QuizService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuizSessionRepository quizSessionRepository;

    // Start a new quiz session
    public QuizSession startNewSession(String userName) {
        List<Question> questions = getRandomQuestions();
        QuizSession session = new QuizSession(userName, questions);
        return quizSessionRepository.save(session);
    }

    // Get a random question for the given session
    public Question getRandomQuestion(Long sessionId) {
        Optional<QuizSession> sessionOptional = quizSessionRepository.findById(sessionId);
        if (sessionOptional.isPresent()) {
            QuizSession session = sessionOptional.get();
            return session.getQuestions().get(new Random().nextInt(session.getQuestions().size()));
        }
        throw new RuntimeException("Quiz session not found!");
    }

    // Submit an answer for a question in the quiz
    public boolean submitAnswer(Long sessionId, Long questionId, String answer) {
        Optional<QuizSession> sessionOptional = quizSessionRepository.findById(sessionId);
        if (sessionOptional.isPresent()) {
            QuizSession session = sessionOptional.get();
            for (Question question : session.getQuestions()) {
                if (question.getId().equals(questionId)) {
                    boolean isCorrect = question.getCorrectAnswer().equalsIgnoreCase(answer);
                    if (isCorrect) {
                        session.incrementCorrectAnswers();
                    } else {
                        session.incrementIncorrectAnswers();
                    }
                    quizSessionRepository.save(session);
                    return isCorrect;
                }
            }
        }
        throw new RuntimeException("Quiz session or question not found!");
    }

    // Get stats for the session
    public QuizSession getSessionStats(Long sessionId) {
        return quizSessionRepository.findById(sessionId).orElseThrow(() -> new RuntimeException("Session not found"));
    }

    // Helper method to get random questions
    private List<Question> getRandomQuestions() {
        List<Question> allQuestions = questionRepository.findAll();
        List<Question> randomQuestions = new ArrayList<>();
        Random random = new Random();

        while (randomQuestions.size() < 3 && !allQuestions.isEmpty()) {
            Question question = allQuestions.get(random.nextInt(allQuestions.size()));
            if (!randomQuestions.contains(question)) {
                randomQuestions.add(question);
            }
        }
        return randomQuestions;
    }
}
