package com.example.quizapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class QuizAppController {
    private List<Quiz> quizzes = new ArrayList<>();

    @GetMapping("/show")
    public List<Quiz> show() {
        return quizzes;
    }

    @PostMapping("/create")
    public void create(@RequestParam String question, @RequestParam boolean answer){
        Quiz quiz = new Quiz(question, answer);
        quizzes.add(quiz); // クイズの追加
    }

    // checkメソッド
    @GetMapping("/check")
    public String check(@RequestParam String question, boolean answer){
        // TODO: 回答の可否をチェックする
    }
}
