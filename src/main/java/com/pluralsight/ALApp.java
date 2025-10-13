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
            String choice  = scan.nextLine().toLowerCase();

            switch (choice) {
                case "D":
                    addDeposit(scan);
                    break;

                case "P":
                  //  makePayment(scan);
                    break;

                case "L":
                 //   showLedger(scan);

                case "X":
                    System.out.println("Stay Blessed");
                    appOpen = false;
                    break;

                default:
                    System.out.println("Try Again");



            }

            if (choice.equals("X")){
                appOpen = false;
            }
        }

    }
    public static void addDeposit(Scanner scan) {
        System.out.println("Please Make Your Deposit Below");
        System.out.println("Add Deposit Here");
        double amount = scan.nextDouble();
        scan.nextLine();
        System.out.println();

        System.out.println("Add Description: ");
        String decription = scan.nextLine();

        System.out.println("Enter Date YYY-MM-DD");
        String date = scan.nextLine();

        System.out.println("Enter Deposit");
        System.out.println("Amount $" + amount);
        System.out.println("Description" + description);
        System.out.println("Date" + date);
    }
    public static void showLedgar(Scanner scan){
        System.out.println("Ledgar");
        System.out.println("Here Are Your Transactions");


    }
    public static void makePayment(Scanner scan_){
        System.out.println( "Make A Payment");
        System.out.println("Enter Payment Here-----");
        System.out.println("Who Will this Payment be Made To" );
        System.out.println("");
    }
}
