package ua.com.alevel;

import java.util.Random;


public class Main {
    public static void main(String[] args) {

        Random random = new Random();

        int Num = 0;

        while(Num < 6) {
            Num = 0;
            for (int i = 0; i < 6; i++) {
                ua.com.alevel.Test test = new ua.com.alevel.Test(random.nextBoolean());
                if (test.gym() == 1) {
                    Num += 1;
                } else {
                    System.out.println("");
                    break;
                }
            }
        }

        System.out.println("\nBingo");

    }

}