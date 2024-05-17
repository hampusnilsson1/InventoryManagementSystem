package org.example;

import java.util.Scanner;

public class GetInput {
    static Scanner scanner = new Scanner(System.in);

    public static int getIntInput() {
        while (true) {
            try {
                int input = Integer.parseInt(scanner.nextLine());
                return input;
            } catch (Exception e) {
                System.out.println("Try Again, Input a number!");
            }
        }
    }

    public static String getStringInput() {
        return scanner.nextLine();
    }

    public static boolean getYes() {
        System.out.println("Yes/No");
        if (GetInput.getStringInput().toLowerCase().equals("yes")) {
            return true;
        }
        return false;
    }
}
