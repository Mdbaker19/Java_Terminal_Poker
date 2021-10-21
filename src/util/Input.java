package util;

import java.util.Scanner;

public class Input {

    private static final Scanner sc = new Scanner(System.in);

    public static String getInput(String message) {
        System.out.println(message);
        String response = sc.next();
        if(response.trim().length() < 1) {
            return getInput("Enter a valid input");
        }
        return format(response);
    }

    public static int getNumber(String message, int min, int max) {
        String input = getInput(message);
        int num;
        try {
            num = Integer.parseInt(input);
            if(num < min || num > max) {
                return getNumber("Not within range", min, max);
            }
        } catch (NumberFormatException e) {
            return getNumber(input + " is not a valid input", min, max);
        }
        return num;
    }

    private static String format(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }

}
