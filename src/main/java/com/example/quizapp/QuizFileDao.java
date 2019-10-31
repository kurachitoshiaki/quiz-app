package com.example.quizapp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class QuizFileDao {

    
    private static final String FILE_PATH = "quizzes.txt";

    public void write(List<Quiz> quizzes) throws IOException {
        List<String> lines = new ArrayList<>();
        for (Quiz quiz: quizzes){
            lines.add(quiz.toString());
        }
        Path path = Paths.get(FILE_PATH);

        //第一引数・・・書き込み先のファイルパス
        //第二引数・・・書き込むデータ
        Files.write(path, lines);
    }
}
