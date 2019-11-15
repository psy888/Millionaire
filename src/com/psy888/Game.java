package com.psy888;

import java.util.Scanner;

public class Game {
    private Question[] questions; //15 вопросов
    int curPrize;
    private String userName;
    private int[] prize;
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
        this.prize = new int[]{100, 200, 300, 500, 1000, 2000, 4000, 8000, 16000, 32000, 64000, 125000, 250000, 500000, 1000000};
        questions = new Question[15];
        //генерация вопросов
        for (int i = 0; i < questions.length; i++) {
            int rightAnswer = (int) (Math.random() * 4);
            String[] answers = new String[4];
            for (int j = 0; j < answers.length; j++) {
                if (j == rightAnswer) {
                    answers[j] = "Правильный ответ";
                }else {
                    answers[j] = "не верно";
                }
            }
            questions[i] = new Question("Вопрос " + i, answers, rightAnswer);
        }
    }

    //Пустой
    public Game() {
    }


    public Game(String name) {
        this.userName = name;
    }


    public void start() {
        ui.printMsg("============================================================================");
        ui.printMsg("======================= Как стать миллионером? =============================");
        ui.printMsg("============================================================================");
        for (int i = 0; i < questions.length; i++) {
            int answer;
            // задавать вопрос пока не будет ответа 1-4
            ask(i, NO_HELP); //задать вопрос
            //todo добавить  2.забрать деньги
            answer = getAnswer(); //получить ответ
            System.out.println("answer = " + answer);
            switch (answer) {
                case HELP_CALL:// звонок
                    if (isCallUsed) break;
                    ask(i, HELP_CALL);
                    isCallUsed = true;
                    answer = getAnswer();
                    break;
                case HELP_50: // 50/50
                    if (is50Used) break;
                    ask(i, HELP_50);
                    is50Used = true;
                    answer = getAnswer();
                    break;
            }

            //проверка
            if (isRightAnswer(questions[i], answer)) {
                curPrize = prize[i]; // сумма текущего выиграша
                ui.printMsg("Верно! \nВаш выиграш составляет : " + curPrize + " грн.");
            } else {
                //проиграл
                ui.printMsg("Неправильно! \nВаш выиграш составляет : " + getWonSum(i) + " грн."); //вывод незгораемой суммы
                return;
            }
        }


    }


    //todo перемешивать вопросы
    private void shuffleQuestions() {

    }

    private int getWonSum(int i) {
        int wonSum = 0;
        if (i < 5 && i > 0) {
            wonSum = prize[0];
        } else if (i >= 5 && i < 10) {
            wonSum = prize[5];
        } else if (i >= 10) {
            wonSum = prize[5];
        }
        return wonSum;
    }


    private void ask(int i, int help) {
        ui.printQuestion(questions[i], help);
    }

    private int getAnswer() {
        Scanner userInput = new Scanner(System.in);
        ui.printMsg("Введите ответ (A,B,C,D) :");

        if (!is50Used || !isCallUsed) {
            ui.printMsg("Или выберете подсказку \n" +
                    ((!is50Used) ? "50/50 - введите 50\n" : "") +
                    ((!isCallUsed) ? "Помощь зала - введите H" : ""));
        }

        int answer;
        String userAnswer = userInput.nextLine().trim().toUpperCase();
        switch (userAnswer) {
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
                ui.printMsg("Неверный ввод :" + userAnswer + " попробуйте еще.");
                answer = getAnswer();
        }
//        System.out.println("answer = " + answer);
        return answer;
    }

    private boolean isRightAnswer(Question q, int index) {
        if (q.rightAnswer == index) {
            return true;
        }
        return false;
    }


}
