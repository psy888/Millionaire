package com.psy888;

public class UI {


    public void printQuestion(Question q){
        System.out.println("Внимание вопрос :");
        System.out.println(q.getQuestion());

        for (int i = 0; i < q.getAnswers().length; i++) {
            String answer = getLetter(i) + "). " + q.getAnswers()[i];
            if (i % 2 == 0) {
                System.out.print(answer + "\t\t");
            } else {
                System.out.println(answer + "\n");
            }
        }
    }


    public String getLetter (int index){
        String letter;
        switch (index){
            case 0:
                letter = "A";
                break;
            case 1:
                letter = "B";
                break;
            case 2:
                letter = "C";
                break;
            case 3:
                letter = "D";
                break;
            default:
                letter="Z"; // просто так

        }
        return letter;
    }

    public void printMsg(String str){
        System.out.println(str);
    }
}
