package ua.com.alevel;

import java.util.Random;

public class Test {

    Test (boolean bag) {
        isBag = bag;
    }

    boolean isBag;

    Random random = new Random();

    public int gym() {
        if(isBag) {
            if (random.nextBoolean()) {
                System.out.println("Bag");
                return 0;
            } else {
                System.out.println("Yes");
                return 1;
            }

        } else {
            System.out.println("Yes");
            return 1;
        }
    }


}

