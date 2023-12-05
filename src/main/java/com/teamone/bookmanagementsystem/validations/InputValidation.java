package com.teamone.bookmanagementsystem.validations;
/*
 * Copyright(C)2022
 * Mock_project
 * Record of change:
 * DATE       Version     AUTHOR     Description
 * 8/8/2022    1.0         ADMIN    First Implement
 */
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class InputValidation {
    private final static Scanner scanner = new Scanner(System.in);
    public boolean checkPassword(String pass) {
        String regex = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{6,}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(pass);
        return matcher.matches();
    }
    public int checkDate(String date) {
        String now = java.time.LocalDate.now().toString();
        return date.compareTo(now);
    }
    public boolean checkUsername(String username) {
        String regex = "^[A-Za-z]\\w{5,29}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }
    public static String inputString() {
        while (true) {
            String result = scanner.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }
}
