package com.example.calculator;

import java.io.Serializable;

public class QuizResult implements Comparable<QuizResult>, Serializable {

//    private String operation;
    private String answer;
    private String resultAction; //Right / Wrong

    public QuizResult(){

    }

    public QuizResult(String operation, String answer, String resultAction) {
        //this.operation = operation;
        //this.answer = answer;
        this.resultAction = resultAction;
    }

//    public String getAnswer() {
//        return answer;
//    }
//
//    public void setAnswer(String answer) {
//        this.answer = answer;
//    }

    public String getResultAction() {
        return resultAction;
    }

    public void setResultAction(String resultAction) {
        this.resultAction = resultAction;
    }




    @Override
    public String toString() {
        return //"Task: " + operation + "\n" +
               // "Answer= " + answer + "\n" +
                "Correctness: " + resultAction;
    }



    @Override
    public int compareTo(QuizResult quizResult1) {
        QuizResult object = quizResult1;
        return resultAction.compareTo(object.getResultAction());
    }
}
