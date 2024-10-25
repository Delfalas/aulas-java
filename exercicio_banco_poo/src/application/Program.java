package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Account account;

		System.out.println("Enter the account number ");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.println("Enter account holder ");
		System.out.print("Name: ");
		sc.nextLine();
		String holder = sc.nextLine();
		System.out.println("Is there an initial deposit? (y/n)? ");
        char response = sc.next().charAt(0);
        sc.nextLine();
        if (response == 'y') {
        	System.out.println("Enter initial deposit value: ");
        	double balance = sc.nextDouble();
        	account = new Account(number, holder, balance);
        }
        else {
        	account = new Account(number, holder);
        }

		System.out.println();
		System.out.println("Account data: " + account);

		System.out.println();
		System.out.println("Enter a deposit value: ");
		double balance = sc.nextDouble();
		account.deposit(balance);

		System.out.println();
		System.out.println("Account data: " + account);

		System.out.println();
		System.out.println("Enter a withdraw value: ");
		balance = sc.nextDouble();
		account.withdraw(balance);

		System.out.println();
		System.out.println("Account data: " + account);

		sc.close();
	}
		
}