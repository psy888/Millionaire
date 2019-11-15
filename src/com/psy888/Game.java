package com.psy888;

import java.util.Scanner;

public class Game {
    private Question[] questions; //15 вопросов
    int curPrize;
    private String userName;
    private int [] prize;
    private UI ui; //User interface
//    private static final String[] answerLetters = new String[]{"A","B","C","D"};


    {
        this.ui = new UI();
        this.prize = new int[]{100,200,300,500,1000,2000,4000,8000,16000,32000,64000,125000,250000,500000,1000000};
    }
    //Пустой
    public Game() {
    }


    public Game(String name) {
        this.userName = name;
    }



    public void start(){
        ui.printMsg("============================================================================");
        ui.printMsg("======================= Как стать миллионером? =============================");
        ui.printMsg("============================================================================");
        for (int i = 0; i < questions.length; i++) {
            ask(i);
            int answer = getAnswer();
            if(isRightAnswer(questions[i],answer)){
                curPrize = prize[i];
            }else {
               //проиграл
                ui.printMsg("Неправильно!\nВаш выиграш составляет : " + getWonSum(i) + " грн.");
                return;
            }
        }


    }

    private void shuffleQuestions(){

    }

    private int getWonSum(int i){
        int wonSum = 0;
        if(i<5&&i>0){
            wonSum = prize[1];
        }else if(i>=5&&i<10){
            wonSum = prize[5];
        }else if(i>=10){
            wonSum = prize[5];
        }
        return wonSum;
    }


    public void ask(int i){
        ui.printQuestion(questions[i]);
    }

    private int getAnswer(){
        Scanner userInput = new Scanner(System.in);
        ui.printMsg("Введите ответ (A,B,C,D) :");
        int answer;
        String userAnswer = userInput.nextLine().trim().toUpperCase();
        switch (userAnswer){
            case "A":
                answer = 0;
                break;
            case "B":
                answer = 1;
                break;
            case "C":
                answer = 2;
                break;
            case "D":
                answer = 3;
                break;
            default:
                ui.printMsg("Неверный ввод :" +  userAnswer + " попробуйте еще.");
                answer = getAnswer();
        }
        return answer;
    }

    private boolean isRightAnswer(Question q, int index){
        if(q.rightAnswer == index){
            return true;
        }
        return false;
    }


}
