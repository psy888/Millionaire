package com.psy888;

import java.util.Arrays;

public class Question {
    String question;
    String[] answers = new String[4];
    int rightAnswer;

    public Question(String question, String[] answers, int rightAnswer) {
        this.question = question;
        this.answers = answers;
        this.rightAnswer = rightAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getAnswers() {
        return Arrays.copyOf(answers,answers.length);
    }

    public void setAnswers(String[] answers) {
        this.answers = answers;
    }

    public int getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(int rightAnswer) {
        this.rightAnswer = rightAnswer;
    }



}
