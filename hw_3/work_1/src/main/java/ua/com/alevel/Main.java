package ua.com.alevel;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int sum;
        System.out.println("start" );
        while (!(line = buf.readLine()).equals("finish")) {
            sum = 0;
            Pattern pattern = Pattern.compile("[!\\d]*(\\d+)[!\\d]*");
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                sum += Integer.parseInt(matcher.group());
            }
            System.out.println("sum = " + sum );
        }
    }
}