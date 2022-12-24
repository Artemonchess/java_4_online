package ua.com.alevel;

import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int sum;
        int number;
        System.out.println("start");
        while (!(line = reader.readLine()).equals("finish")) {
            try {
                number = Integer.parseInt(line);
                if (number >= 0 && number <= 10) {
                    sum = number * 45 + ((number / 2) * 5) + (((number - 1) / 2) * 15);
                    System.out.println((sum / 60 + 9) + ":" + (sum % 60));
                }
            } catch (Exception e) {
                System.out.println(line + " not simbol ");
            }
        }
    }
}