package com.example.alvin.histora;

//Each topic has an array of questions and an array of answers, can plug into the quiz activity
public class QuizTopic {

    String[] mQuestions;
    String[] mAnswers;

    public QuizTopic(String[] questions, String[] answers){
        mQuestions = questions;
        mAnswers = answers;
    }

    public String[] getQuestions() {
        return mQuestions;
    }

    public void setQuestions(String[] mQuestions) {
        this.mQuestions = mQuestions;
    }

    public String[] getAnswers() {
        return mAnswers;
    }

    public void setAnswers(String[] mAnswers) {
        this.mAnswers = mAnswers;
    }
}
