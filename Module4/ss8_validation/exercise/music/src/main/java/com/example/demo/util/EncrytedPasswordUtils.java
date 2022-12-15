package com.example.demo.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Scanner;

public class EncrytedPasswordUtils {

//    // Encryte Password with BCryptPasswordEncoder
//    public static String encrytePassword(String password) {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        return encoder.encode(password);
//    }
//
//    public static void main(String[] args) {
//        String password = "2412";
//        String encrytedPassword = encrytePassword(password);
//
//        System.out.println("Encryted Password: " + encrytedPassword);
//    }

    public static void main(String[] args) {
        System.out.println("nhập chiều dài cạnh");
        Scanner scanner = new Scanner(System.in);
        
        int number = scanner.nextInt();
        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= i; j++) {
                if (i==1 || j ==1 || i==number || j ==i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

}