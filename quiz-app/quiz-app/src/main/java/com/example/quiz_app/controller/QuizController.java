package com.example.quiz_app.controller;

import com.example.quiz_app.model.Question;
import com.example.quiz_app.model.QuizSession;
import com.example.quiz_app.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/start")
    public QuizSession startQuiz(@RequestParam String userName) {
        return quizService.startNewSession(userName);
    }

    @GetMapping("/question/{sessionId}")
    public Question getRandomQuestion(@PathVariable Long sessionId) {
        return quizService.getRandomQuestion(sessionId);
    }

    @PostMapping("/submit")
    public boolean submitAnswer(
            @RequestParam Long sessionId,
            @RequestParam Long questionId,
            @RequestParam String answer) {
        return quizService.submitAnswer(sessionId, questionId, answer);
    }

    @GetMapping("/stats/{sessionId}")
    public QuizSession getStats(@PathVariable Long sessionId) {
        return quizService.getSessionStats(sessionId);
    }
}
