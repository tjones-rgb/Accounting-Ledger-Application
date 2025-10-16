package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ALApp {
    static ArrayList<Transaction> ledger = new ArrayList<>();
    static FileWriter twriter;
    static BufferedWriter writer;
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        try {
            twriter = new FileWriter("src/main/resources/Transaction.csv", true);
            //bufReader.readLine(); //Alternative method to skip first line of csv file
            writer = new BufferedWriter(twriter);
        } catch (IOException e) {
            System.out.println();
        }
        homeScreen(scan);


    }

    public static void homeScreen(Scanner scan) {
        boolean appOpen = true;

        while (appOpen) {
            System.out.println("Welcome To Your Banking App");
            System.out.println();
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment (Debit)");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");
            System.out.print("PLease Make your Selection: ");
            String choice = scan.nextLine().toUpperCase();

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
        System.out.println("Vendor");
        String vendor = scan.nextLine();

        System.out.println("Enter Deposit");
        System.out.println("Amount $" + amount);
        System.out.println("Description: " + description);
        System.out.println("Vendor: " + vendor);
        Transaction transaction = new Transaction(description, vendor, amount);
        ledger.add(transaction);
        try {
            writer.newLine();
            writer.write(transaction.getDate() + "|" + transaction.getTime() + "|" + description + "|" + vendor + "|" + amount);
            writer.flush();
        } catch (IOException e) {
            System.out.println("Sorry Try Again");
        }
        System.out.println("Transaction Complete");

    }

    public static void makePayment(Scanner scan) {
        System.out.println("Make A Payment");
        System.out.print("Enter Payment Here-----");
        double amount = scan.nextDouble();
        scan.nextLine();
        amount = -amount;
        System.out.println("Who Will this Payment be Made To");
        String vendor = scan.nextLine();

        System.out.println("Add Description");
        String description = scan.nextLine();

        System.out.println("Amount: $ " + amount);
        System.out.println("Vendor" + vendor);

        Transaction transaction = new Transaction(description, vendor, amount);
        ledger.add(transaction);
        try {
            writer.newLine();
            writer.write(transaction.getDate() + "|" + transaction.getTime() + "|" + description + "|" + vendor + "|" + amount);
            writer.flush();
        } catch (IOException e) {
            System.out.println("Sorry Try Again");
        }
        System.out.println("Payment Complete: " + transaction);


    }

    public static void showLedger(Scanner scan) {
        System.out.println("Ledger");
        System.out.println("Here Are Your Transactions");
        boolean ledgerOpen = true;


        while (ledgerOpen) {

            System.out.println("Welcome To Your Ledger");
            System.out.println("Options");
            System.out.println("A) All");
            System.out.println("D) Deposits");
            System.out.println("P) Payments");
            System.out.println("R) Reports");
            System.out.println("H) Home");
            System.out.println("Please Make Your Selection:");
            String choice = scan.nextLine().toUpperCase();

            switch (choice) {
                case "A":
                    showAll();
                    break;

                case "D":
                    showDeposits();
                    //   ledger.add("Deposits added");
                    //   ledger.add("Deposit | Amount: $" + amount + " | Date:" + date);
                    break;

                case "P":
                    System.out.println("Payments");
                    showPayments();
                    //     ledger.add("Payment | Amount: -$" + amount + "")
                    break;

                case "R":
                    System.out.println("Reports");
                    showReports(scan);
                    break;

                case "H":
                    ledgerOpen = false;
                    break;

                default:
                    System.out.println("Stay Blessed And Try Again");


            }
        }

    }

    public static void showAll() {
        System.out.println("Here Are Your Transaction");
        for (int i = ledger.size() - 1; i >= 0; i--) {
            System.out.println(ledger.get(i));


        }
    }

    public static void showDeposits() {
        System.out.println("Here Are Your Deposits");
        for (int i = ledger.size() - 1; i >= 0; i--) {
            Transaction entry = ledger.get(i);
            if (entry.getAmount() > 0)
                System.out.println(entry);


        }
    }

    public static void showPayments() {
        System.out.println("Here Are Your Payments");
        if (ledger.isEmpty()) {
            System.out.println("No Payments Have Been Made");
            return;
        }

        for (int i = ledger.size() - 1; i >= 0; i--) {
            Transaction entry = ledger.get(i);

            System.out.println(entry);
        }

    }

    public static void showReports(Scanner scan) {
        boolean reportOpen = true;
        while (reportOpen) {
            System.out.println("Reports Menu");
            System.out.println("1) Month To Date");
            System.out.println("2) Previous Month");
            System.out.println("3) Year To Date");
            System.out.println("4) Previous Year");
            System.out.println("5) Search By Vendor");
//            prompt the user for the vendor name
//            and display all entries for that vendor
            System.out.println("0) Back");
            System.out.print("Make Your Selection: ");

            String selection = scan.nextLine();

            switch (selection) {
                case "1":
                    showMonthToDate();
                    // Month To Date
                    break;

                case "2":
                    showPreviousMonth();
                    // Previous Date
                    break;

                case "3":
                    showYearToDate();
                    // Year To Date
                    break;

                case "4":
                    showPreviousYear();
                    // Previous Year
                    break;

                case "5":
                    searchByVendor(scan);
                    break;

                case "0":
                    reportOpen = false;
                    break;

                default:
                    System.out.println("Error Please Try Again");


            }
        }
    }

    public static void showMonthToDate() {
        System.out.println("Month To Date Transaction:");
        java.time.LocalDate today = java.time.LocalDate.now();
        int currentMonth = today.getMonthValue();
        int currentYear = today.getYear();



        for (int i = ledger.size() - 1; i >= 0; i--) {
                Transaction entry = ledger.get(i);
                java.time.LocalDate entryDate = entry.getDate();

                if (entryDate.getMonthValue() == currentMonth && entryDate.getYear() == currentYear) {
                    System.out.println(entry);
                }
            }
        }

        public static void showPreviousMonth () {
            System.out.println("Previous Month Transactions");
            java.time.LocalDate today = java.time.LocalDate.now();
            int currentMonth = today.getMonthValue();
            int currentYear = today.getYear();
            int previousMonth = currentMonth - 1;
            int yearOfPreviousMonth = currentYear;

            if (previousMonth == 0) {
                previousMonth = 12;
                yearOfPreviousMonth--;
            }
            for (int i = ledger.size() - 1; i >= 0; i--) {
                Transaction entry = ledger.get(i);
                java.time.LocalDate entryDate = entry.getDate();
                if (entryDate.getMonthValue() == previousMonth && entryDate.getYear() == yearOfPreviousMonth) {
                    System.out.println(entry);
                }
            }
        }

        public static void showPreviousYear () {
            System.out.println("Previous Year Transactions:");
            java.time.LocalDate today = java.time.LocalDate.now();
            int previousYear = today.getYear() - 1;

            for (int i = ledger.size() - 1; i >= 0; i--) {
                Transaction entry = ledger.get(i);
                java.time.LocalDate entryDate = entry.getDate();

                if (entryDate.getYear() == previousYear) {
                    System.out.println(entry);
                }
            }
        }

        public static void showYearToDate () {
            System.out.println("Year To Date Transactions");
            java.time.LocalDate today = java.time.LocalDate.now();
            int currentYear = today.getYear();

            for (int i = ledger.size() - 1; i >= 0; i--) {
                Transaction entry = ledger.get(i);
               java.time.LocalDate entryDate = entry.getDate();

               if (entryDate.getYear() == currentYear) {
                    System.out.println(entry);
                }
            }
        }

        public static void searchByVendor (Scanner scan){
            System.out.print("Enter Vendor Name Here: ");
            String vendorName = scan.nextLine().toLowerCase();
            System.out.println("Results Of Vendors");
            boolean found = false;

            for (int i = ledger.size() - 1; i >= 0; i--) {
                Transaction entry = ledger.get(i);

                if (entry.getVendor().toLowerCase().contains(vendorName)) {
                    System.out.println(ledger.get(i));
                    found = true;

                }
            }
            if (!found) {
                System.out.println("No Transactions Were Made");
            }
        }
    }


