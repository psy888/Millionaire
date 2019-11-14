package com.psy888;

public class Game {
    Question[] questions; //15 вопросов
    int curQuestion;
    String userName;
    int [] prize;
    UI ui; //User interface


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
        System.out.println("============================================================================");
        System.out.println("======================= Как стать миллионером? =============================");
        System.out.println("============================================================================");
    }

    private void shuffleQuestions(){

    }

    public void ask(int i){
        ui.printQuestion(questions[i]);
    }

    public boolean isRightAnswer(Question q, int index){
        if(q.rightAnswer == index){
            return true;
        }
        return false;
    }


}
