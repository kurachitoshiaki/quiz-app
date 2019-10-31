package com.example.quizapp;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QuizTest {

    @Test
    public void toStringWhenMaru(){
        Quiz quiz = new Quiz( question: "問題文", answer: true);
        assertThat(quiz.toString(), is("問題文 ○"));
    }
    @Test
    public void toStringWhenBatsu(){
        Quiz quiz = new Quiz( question: "問題文", answer: false);
        assertThat(quiz.toString(), is("問題文 ×"));
    }

    public void fromStringWhenMaru(){
        String line = "問題文1 ○";
        Quiz quiz = Quiz.fromString(line);

        assertThat(quiz.getQuestion(), is("問題文1"));
        assertThat(quiz.toString(), is(true));
    }
}
