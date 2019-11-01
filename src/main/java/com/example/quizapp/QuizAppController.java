package com.example.quizapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class QuizAppController {
    private List<Quiz> quizzes = new ArrayList<>();
    private QuizFileDao quizFileDao = new QuizFileDao();

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
        // 回答の可否をチェックする
        for (Quiz quiz: quizzes){
            if (quiz.getQuestion().equals(question)){
                if (quiz.isAnswer() == answer){
                    return "正解!";
                } else {
                    return "不正解!";
                }
            }
        }
        return  "問題がありません";
    }

    @PostMapping("/save")
    public String save(){
        try {
            quizFileDao.write(quizzes);
            return "ファイルに保存しました";
        } catch (IOException e) {
            e.printStackTrace();
            return "ファイルの保存に失敗しました";
        }
    }

    @GetMapping("/load")
    public String load(){
        try {
            quizzes = quizFileDao.read();
            return "ファイルを読み込みました";
        } catch (IOException e) {
            e.printStackTrace();
            return "ファイルの読み込みに失敗しました";
        }
    }
}
