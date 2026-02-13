package com.example.ConversationQuestions.controller;

import com.example.ConversationQuestions.model.ConversationQuestion;
import com.example.ConversationQuestions.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping({"/api/questions", "/api/questions/"})
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public List<ConversationQuestion> getAll() {
        return questionService.getAllQuestions();
    }

    @GetMapping({"/{id}", "/{id}/"})
    public ResponseEntity<ConversationQuestion> getById(@PathVariable String id) {
        ConversationQuestion question = questionService.getQuestionById(id);

        if (question == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(question);
    }

    @GetMapping({"/category/{category}", "/category/{category}/"})
    public List<ConversationQuestion> getByCategory(@PathVariable String category) {
        return questionService.getQuestionsByCategory(category);
    }

    @GetMapping("/random")
    public ConversationQuestion getRandom() {
        return questionService.getRandomQuestion();
    }
}
