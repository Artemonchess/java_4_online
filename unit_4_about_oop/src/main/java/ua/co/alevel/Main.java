package ua.co.alevel;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int count = 100;
        Random random = new Random();
        Test[] kod = new Test[random.nextInt(count)];
        System.out.println("kod = " + kod.length);

        for (int i = 0; i < kod.length; i++) {
            kod[i] = new Test();
            kod[i].name = String.valueOf(i);
            random = new Random();
            int result = random.nextInt(1);
            if (result == 0) {
                kod[i].isStupid = true;
            } else {
                kod[i].isStupid = false;
            }
        }

        for (int i = 0; i < kod.length; i++) {
            System.out.println(
                    "kod = " + kod[i].name + " " + kod[i].isStupid);
        }
        for (int i = 1; i < kod.length; i++) {
            kod[i] = new Test();
            kod[i].name = String.valueOf(i);
            random = new Random();
            int result = random.nextInt(2);
            if (result == 1) {
                kod[i].isStupid = true;
            } else {
                kod[i].isStupid = false;
            }
        }

        for (int i = 1; i < kod.length; i++) {
            System.out.println(
                    "kod = " + kod[i].name + " " + kod[i].isStupid);
        }
        for (int i = 2; i < kod.length; i++) {
            kod[i] = new Test();
            kod[i].name = String.valueOf(i);
            random = new Random();
            int result = random.nextInt(3);
            if (result == 2) {
                kod[i].isStupid = true;
            } else {
                kod[i].isStupid = false;
            }
        }

        for (int i = 2; i < kod.length; i++) {
            System.out.println(
                    "kod = " + kod[i].name + " " + kod[i].isStupid);
        }
        for (int i = 3; i < kod.length; i++) {
            kod[i] = new Test();
            kod[i].name = String.valueOf(i);
            random = new Random();
            int result = random.nextInt(4);
            if (result == 3) {
                kod[i].isStupid = true;
            } else {
                kod[i].isStupid = false;
            }
        }

        for (int i = 3; i < kod.length; i++) {
            System.out.println(
                    "kod = " + kod[i].name + " " + kod[i].isStupid);
        }
        for (int i = 4; i < kod.length; i++) {
            kod[i] = new Test();
            kod[i].name = String.valueOf(i);
            random = new Random();
            int result = random.nextInt(5);
            if (result == 4) {
                kod[i].isStupid = true;
            } else {
                kod[i].isStupid = false;
            }
        }

        for (int i = 4; i < kod.length; i++) {
            System.out.println(
                    "kod = " + kod[i].name + " " + kod[i].isStupid);
        }
        for (int i = 5; i < kod.length; i++) {
            kod[i] = new Test();
            kod[i].name = String.valueOf(i);
            random = new Random();
            int result = random.nextInt(6);
            if (result == 5) {
                kod[i].isStupid = true;
            } else {
                kod[i].isStupid = false;
            }
        }

        for (int i = 5; i < kod.length; i++) {
            System.out.println(
                    "kod = " + kod[i].name + " " + kod[i].isStupid);
        }
        for (int i = 6; i < kod.length; i++) {
            System.out.println("\nSTOP");
        }


    }
}