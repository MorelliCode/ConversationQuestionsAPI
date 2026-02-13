package com.example.ConversationQuestions.service;

import com.example.ConversationQuestions.model.ConversationQuestion;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class QuestionService {
    private List<ConversationQuestion> questions = new ArrayList<>();
    private final ObjectMapper objectMapper;

    public QuestionService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @PostConstruct
    public void loadQuestions() {
        try (InputStream inputStream = getClass().getResourceAsStream("/questions.json")) {
            if (inputStream == null) {
                throw new RuntimeException("Could not find questions.json in resources!");
            }

            questions = objectMapper.readValue(inputStream, new TypeReference<List<ConversationQuestion>>() {});

            System.out.println("Loaded " + questions.size() + " questions successfully.");
        } catch (IOException e) {
            throw new RuntimeException("Failed to load conversation questions", e);
        }
    }

    public List<ConversationQuestion> getAllQuestions() {
        return this.questions;
    }

    public ConversationQuestion getRandomQuestion() {
        if (questions.isEmpty()) {
            return null;
        }

        Random random = new Random();
        return this.questions.get(random.nextInt(questions.size()));
    }
}
