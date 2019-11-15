package com.psy888;

public class UI {


    public void printQuestion(Question q , int help){ //-1 - no Help
        System.out.println("Внимание вопрос :");
        System.out.println(q.getQuestion());
        String[] answers = q.getAnswers();

        switch (help){
            case Game.HELP_50:
                int wrongAnswCnt = 2;
                    for (int i = 0; i < answers.length; i++) {
                        if(i==q.rightAnswer){
                            continue; // пропуск правильного ответа
                        }else if(wrongAnswCnt>0){
                            answers[i] = "";
                            wrongAnswCnt--;
                        }
                    }
                break;
            case Game.HELP_CALL:
                answers[q.getRightAnswer()] += " * ";
                break;
        }

        for (int i = 0; i < answers.length; i++) {
            String answer = getLetter(i) + "). " + answers[i];

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
