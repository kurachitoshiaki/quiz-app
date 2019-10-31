package com.example.quizapp;

public class Quiz {

    /**
     * 問題文
     */
    private String question;

    /**
     * クイズの正解
     */
    private boolean answer;

    public Quiz(String question, boolean answer){
        this.question = question;
        this.answer = answer;
    }

    public  String getQuestion(){
        return question;
    }

    public boolean isAnswer(){
        return answer;
    }

    @Override
    public String toString(){
        String marubatu = answer ? "○" : "×";
        return question + " " + marubatu;
    }

    public static Quiz fromString(String line) {
        String question = line.substring(0, line.length() - 2);
        boolean answer = line.endsWith("○");

        return new Quiz(question, answer);
    }
}
