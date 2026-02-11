package com.example.ConversationQuestions.service;

import com.example.ConversationQuestions.model.ConversationQuestion;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuestionService {
    private final List<ConversationQuestion> questions;

    public QuestionService() {
        this.questions = List.of(
            new ConversationQuestion("1", "What is your favorite book?", "Hobbies", "Simple Present (to be)"),
            new ConversationQuestion("2", "If you could live anywhere, where would you live?", "Travel", "Second Conditional"),
            new ConversationQuestion("3", "What is your biggest fear?", "Deep", "Simple Present (to be)")
        );
    }

    public List<ConversationQuestion> getAllQuestions() {
        return this.questions;
    }

    public ConversationQuestion getRandomQuestion() {
        Random random = new Random();
        return this.questions.get(random.nextInt(questions.size()));
    }
}
