package com.ace;

import java.util.*;

public class BankAccount {
    public static Scanner scr = new Scanner(System.in);
    static int id = 1000;
    String uid;
    String name;
    String address;
    String type;
    double balance;
    public static int no_of_trans = 0;
    boolean isLocked = false;
    List<String> transactionHistory = new ArrayList<>();

    BankAccount() {
        uid = null;
        name = address = type = null;
    }

    BankAccount(String name, String address, String type, double balance) {
        this.uid = generateUID();
        this.name = name;
        this.address = address;
        this.type = type;
        this.balance = balance;
    }

    String generateUID() {
        return "BA" + Integer.toString(id++);
    }

    void display() {
        System.out.println("");
        System.out.println("\t*** ACCOUNT INFORMATION ***");
        System.out.println("|     Name of Holder    : " + this.name);
        System.out.println("|     Account No        : " + this.uid);
        System.out.println("|     Account Type      : " + this.type);
        System.out.println("|     Available Balance : ₹" + this.balance);
        System.out.println("|     Address of Holder : " + this.address);
        System.out.println("|     Account Status    : " + (isLocked ? "Locked" : "Active"));
        System.out.println("");
    }

    void deposit() {

        if (isLocked) {
            System.out.println("Account is locked. Transaction not allowed.");
            return;
        }
        System.out.println("");
        System.out.println("Account No : " + this.uid);
        System.out.println("Name : " + this.name);
        System.out.print("Enter amount to be Deposited : ₹");
        double amount = Double.parseDouble(scr.nextLine());
        this.balance += amount;
        transactionHistory.add("Deposited: ₹" + amount);
        System.out.println("");
        System.out.println("Amount Credited Successfully...");
        System.out.println("");
        no_of_trans++;
    }

    void withdraw() {
        if (isLocked) {
            System.out.println("Account is locked. Transaction not allowed.");
            return;
        }
        System.out.println("");
        System.out.println("Account No : " + this.uid);
        System.out.println("Name : " + this.name);
        System.out.print("Enter amount to be Withdrawn : ₹");
        double amount = Double.parseDouble(scr.nextLine());
        if (amount > this.balance) {
            System.out.println("Insufficient Balance!");
        } else {
            this.balance -= amount;
            transactionHistory.add("Withdrawn: ₹" + amount);
            System.out.println("");
            System.out.println("Amount Debited Successfully...");
            System.out.println("");
            no_of_trans++;
        }
    }

    void changeAddress() {
        if (isLocked) {
            System.out.println("Account is locked. Modification not allowed.");
            return;
        }
        System.out.println("");
        System.out.println("Account No : " + this.uid);
        System.out.println("Name : " + this.name);
        System.out.print("Enter New Address : ");
        this.address = scr.nextLine();
        transactionHistory.add("Address changed to: " + this.address);
        System.out.println("");
        System.out.println("Address Successfully Changed...");
        System.out.println("");
    }

    void lockAccount() {
        this.isLocked = true;
        transactionHistory.add("Account locked.");
        System.out.println("Account has been locked.");
    }

    void unlockAccount() {
        this.isLocked = false;
        transactionHistory.add("Account unlocked.");
        System.out.println("Account has been unlocked.");
    }

    void calculateInterest(double rate) {
        double interest = this.balance * rate / 100;
        this.balance += interest;
        transactionHistory.add("Interest credited: ₹" + interest);
        System.out.println("Interest of ₹" + interest + " credited to your account.");
    }

    void printTransactionHistory() {
        System.out.println("Transaction History for Account No: " + this.uid);
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    public static void main(String[] args) {
        System.out.print("Enter Number of depositors: ");
        int n = Integer.parseInt(scr.nextLine());

        BankAccount[] accounts = new BankAccount[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter Information for Depositor no. " + (i + 1));
            System.out.print("Enter name: ");
            String name = scr.nextLine();
            System.out.print("Type of Account: ");
            String type = scr.nextLine();
            System.out.print("Enter City: ");
            String address = scr.nextLine();
            System.out.print("Enter Balance: ₹");
            double balance = Double.parseDouble(scr.nextLine());
            accounts[i] = new BankAccount(name, address, type, balance);
            System.out.println("");
        }

        int flag = 1;
        while (flag == 1) {
            System.out.println("");
            System.out.println("MENU FOR ACCOUNT");
            System.out.println("1. Print information of any depositor");
            System.out.println("2. Add amount to the account of any depositor");
            System.out.println("3. Remove some amount from account of any depositor");
            System.out.println("4. Change Address of any depositor");
            System.out.println("5. Lock account");
            System.out.println("6. Unlock account");
            System.out.println("7. Calculate interest");
            System.out.println("8. Print total number of transactions");
            System.out.println("9. Print transaction history");
            System.out.println("10. Stop");
            System.out.print("Enter your Choice: ");
            int choice = Integer.parseInt(scr.nextLine());
            System.out.println("");

            switch (choice) {
                case 1:
                    System.out.print("Depositor no.: ");
                    int num = Integer.parseInt(scr.nextLine());
                    if (num > 0 && num <= n) {
                        accounts[num - 1].display();
                    } else {
                        System.out.println("Invalid depositor number!");
                    }
                    break;
                case 2:
                    System.out.print("Depositor no.: ");
                    num = Integer.parseInt(scr.nextLine());
                    if (num > 0 && num <= n) {
                        accounts[num - 1].deposit();
                    } else {
                        System.out.println("Invalid depositor number!");
                    }
                    break;
                case 3:
                    System.out.print("Depositor no.: ");
                    num = Integer.parseInt(scr.nextLine());
                    if (num > 0 && num <= n) {
                        accounts[num - 1].withdraw();
                    } else {
                        System.out.println("Invalid depositor number!");
                    }
                    break;
                case 4:
                    System.out.print("Depositor no.: ");
                    num = Integer.parseInt(scr.nextLine());
                    if (num > 0 && num <= n) {
                        accounts[num - 1].changeAddress();
                    } else {
                        System.out.println("Invalid depositor number!");
                    }
                    break;
                case 5:
                    System.out.print("Depositor no.: ");
                    num = Integer.parseInt(scr.nextLine());
                    if (num > 0 && num <= n) {
                        accounts[num - 1].lockAccount();
                    } else {
                        System.out.println("Invalid depositor number!");
                    }
                    break;
                case 6:
                    System.out.print("Depositor no.: ");
                    num = Integer.parseInt(scr.nextLine());
                    if (num > 0 && num <= n) {
                        accounts[num - 1].unlockAccount();
                    } else {
                        System.out.println("Invalid depositor number!");
                    }
                    break;
                case 7:
                    System.out.print("Depositor no.: ");
                    num = Integer.parseInt(scr.nextLine());
                    if (num > 0 && num <= n) {
                        System.out.print("Enter interest rate: ");
                        double rate = Double.parseDouble(scr.nextLine());
                        accounts[num - 1].calculateInterest(rate);
                    } else {
                        System.out.println("Invalid depositor number!");
                    }
                    break;
                case 8:
                    System.out.println("Total number of transactions today: " + no_of_trans);
                    break;
                case 9:
                    System.out.print("Depositor no.: ");
                    num = Integer.parseInt(scr.nextLine());
                    if (num > 0 && num <= n) {
                        accounts[num - 1].printTransactionHistory();
                    } else {
                        System.out.println("Invalid depositor number!");
                    }
                    break;
                case 10:
                    System.out.println("Exiting...");
                    flag = 0;
                    break;
                default:
                    System.out.println("Wrong Choice!!!");
            }
        }
    }
}
