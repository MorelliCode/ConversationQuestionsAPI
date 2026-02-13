package com.example.ConversationQuestions.controller;

import com.example.ConversationQuestions.model.ConversationQuestion;
import com.example.ConversationQuestions.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public List<ConversationQuestion> getAll() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/random")
    public ConversationQuestion getRandom() {
        return questionService.getRandomQuestion();
    }
}
