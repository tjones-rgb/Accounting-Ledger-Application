package com.pluralsight;

import java.sql.SQLOutput;
import java.util.Locale;
import java.util.Scanner;

public class ALApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        homeScreen(scan);


    }
    public static void homeScreen(Scanner scan){
        boolean appOpen = true;

        while (appOpen){
        System.out.println("Welcome To Your Banking App");
            System.out.println();
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment (Debit)");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");
            System.out.println("PLease Make your Selection");
            String choice  = scan.nextLine().toUpperCase(Locale.ROOT);

            switch (choice) {
                case "D":
               //     addDeoposit(scan);
                    break;

                case "P":
                  //  makePayment(scan);
                    break;

                case "L":
               //     showLedger(scan);

                case "X":



            }

            if (choice.equals("X")){
                appOpen = false;
            }
        }
    }
}
