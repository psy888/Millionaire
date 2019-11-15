package com.psy888;

import java.util.Scanner;

public class Game {
    private Question[] questions; //15 вопросов
    int curPrize;
    private String userName;
    private int [] prize;
    private UI ui; //User interface
    private boolean is50Used;
    private boolean isCallUsed;
    public static final int NO_HELP = -1;
    public static final int HELP_CALL = 4;
    public static final int HELP_50 = 5;
    public static final int TAKE_MONEY = 6;

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
            int answer;
            // задавать вопрос пока не будет ответа 1-4
            do {
                ask(i); //задать вопрос
                //todo добавить 1.выбор подсказки  2.забрать деньги
                answer = getAnswer(); //получить ответ
                switch (answer){
                    case HELP_CALL:// звонок
                        getCallHelp(i);
                        break;
                    case HELP_50: // 50/50
                        get50Help(i);
                        break;
                }
            }while (answer>3);

            //проверка
            if(isRightAnswer(questions[i],answer)){
                curPrize = prize[i]; // сумма текущего выиграша
                ui.printMsg("Верно! \nВаш выиграш составляет : " + curPrize + " грн.");
            }else {
               //проиграл
                ui.printMsg("Неправильно! \nВаш выиграш составляет : " + getWonSum(i) + " грн."); //вывод незгораемой суммы
                return;
            }

        }


    }

    private void get50Help(int i) {

    }

    private void getCallHelp(int i) {
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


    private void ask(int i, int help){
        ui.printQuestion(questions[i], help);
    }

    private int getAnswer(){
        Scanner userInput = new Scanner(System.in);
        ui.printMsg("Введите ответ (A,B,C,D) :");

        if(!is50Used ||!isCallUsed){
            ui.printMsg("Или выберете подсказку \n" +
                    ((!is50Used)?"50/50 - введите 50\n":"") +
                    ((!isCallUsed)?"Помощь зала - введите H":""));
        }

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
            case "H": //help подсказка
                answer = 4;
                break;
            case "50": // 50/50 подсказка
                answer = 5;
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
