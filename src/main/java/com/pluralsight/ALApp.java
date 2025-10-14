package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
            System.out.print("PLease Make your Selection: ");
            String choice  = scan.nextLine().toUpperCase();

            switch (choice) {
                case "D":
                    addDeposit(scan);
                    break;

                case "P":
                    makePayment(scan);
                    break;

                case "L":
                       showLedger(scan);
                    break;


                case "X":
                    System.out.println("Stay Blessed");
                    appOpen = false;
                    break;

                default:
                    System.out.println("Try Again");

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
        String description = scan.nextLine();

        System.out.println("Enter Date YYYY-MM-DD");
        String date = scan.nextLine();

        System.out.println("Enter Deposit");
        System.out.println("Amount $" + amount);
        System.out.println("Description" + description);
        System.out.println("Date" + date);
        System.out.println("Transaction Complete");
    }

    public static void makePayment(Scanner scan){
        System.out.println( "Make A Payment");
        System.out.print("Enter Payment Here-----");
        double amount = scan.nextDouble();
        scan.nextLine();

        System.out.println("Who Will this Payment be Made To" );
        String vendor = scan.nextLine();

        System.out.println("Enter Date Here (YYYY-MM-DD)");
        String date = scan.nextLine();

        System.out.println("Payment Complete:");

        System.out.println("Amount: $ " + amount);

        System.out.println("Vendor" + vendor);

        System.out.println("Date:" + date);

    } public static void showLedger(Scanner scan){
        System.out.println("Ledger");
        System.out.println("Here Are Your Transactions");

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("src/main/resources/Transaction.csv", true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BufferedWriter writer = new BufferedWriter(fileWriter);

    }

}
