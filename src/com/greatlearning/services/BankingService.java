package com.greatlearning.services;

import com.greatlearning.models.Customer;

import java.util.Scanner;

public class BankingService {

    Scanner sc=new Scanner(System.in);
    int bankBalance=1000;

    public void logOut() {
        System.out.println("====Thank you for banking with us=======");
    }

    public void deposit(Customer customer){
        int amount;
        System.out.println("Enter the deposit amount");
        amount=sc.nextInt();
        if(amount >0){
            System.out.println("Amount deposited successfully");
            customer.setBalance(customer.getBalance()+amount);
            System.out.println("Remaining balance is ::"+ customer.getBalance());
        }else {
            System.out.println("please provide valid input");
        }
    }

    public void withdraw(Customer customer) {
        int amount;
        System.out.println("Enter the withdraw amount");
        amount=sc.nextInt();
        if(customer.getBalance() >=amount){
            System.out.println("Amount withdraw successfully");
            customer.setBalance(customer.getBalance()-amount);
            System.out.println("Remaining balance is ::"+ customer.getBalance());
        }else {
            System.out.println("please provide valid input");
        }
    }

    public void transfer(Customer customer) {
        int amount;
        int otp;
        int otpGenerated;
        int toBeTransferredAccountNo;
        System.out.println("Enter the OTP");
        OTPService otpService=new OTPService();
        otpGenerated=otpService.generateOTP();
        System.out.println("-----Generated OTP is--------");
        System.out.println(otpGenerated);
        System.out.println("Enter the otp");
        otp=sc.nextInt();
                if(otp==otpGenerated){
                    System.out.println("otp validated successful");
                    System.out.println("Enter the amount to be transferred");
                    amount=sc.nextInt();
                    System.out.println("Enter the account to be transferred");
                    toBeTransferredAccountNo= sc.nextInt();
                    if(customer.getBalance() >=amount){
                        System.out.println("Amount was transferred");
                        customer.setBalance(customer.getBalance()-amount);
                        System.out.println("Remaining balance is ::"+ customer.getBalance());
                    }else {
                        System.out.println("insufficient balance");
                    }
                }
    }
}
