package com.greatlearning.main;

import com.greatlearning.models.Customer;
import com.greatlearning.services.BankingService;

import java.util.Scanner;

public class Driver {

    public static void main(String[] args){
        BankingService bankingService=new BankingService();

        Customer customer1=new Customer("password",123456,1000);

        Scanner sc=new Scanner(System.in);
        String password;
        int bankAccountNo;

        System.out.println("Welcome to the login page");
        System.out.println();
        System.out.println("Enter your account number");
        bankAccountNo=sc.nextInt();
        System.out.println("Enter the password");
        password=sc.next();

        Customer loggedInCustomer=new Customer(password,bankAccountNo,1000);

        if(validCustomer(loggedInCustomer,customer1)){
           int option=0;
           do{
               System.out.println();
               System.out.println("================================================");
               System.out.println("1. Deposit");
               System.out.println("2. Withdrawal");
               System.out.println("3. Transfer");
               System.out.println("0. Logout");
               System.out.println("=================================================");
               option= sc.nextInt();

               switch (option){
                   case 0:
                       option=0;
                       bankingService.logOut();
                       break;
                   case 1:
                       bankingService.deposit(loggedInCustomer);
                       break;
                   case 2:
                       bankingService.withdraw(loggedInCustomer);
                       break;
                   case 3:
                       bankingService.transfer(loggedInCustomer);
                       break;
               }
           }while (option!=0);
        }else{
            System.out.println("Please enter valid credentials");
        }
    }

    private static boolean validCustomer(Customer loggedInCustomer, Customer customer1) {
        return loggedInCustomer.getBankAccountNo()== customer1.getBankAccountNo()&& loggedInCustomer.getPassword().equals(customer1.getPassword());
    }
}
