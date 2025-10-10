package com.pluralsight;

import java.sql.SQLOutput;
import java.util.Scanner;

public class ALApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        homeScreen();


    }
    public static void homeScreen(){
        boolean appOpen =true;

        System.out.println("Ledgar Has Been Accessed");
        while (appOpen){
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment (Debit)");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");
            String selection = scanner.nextChar();

        }
    }
}
