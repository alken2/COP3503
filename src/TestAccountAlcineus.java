/*
 Kenneth Alcineus
 This is a program that simulates a basic ATM interface and giving the user the options to check, add, and subtract funds from specific accounts.
 The purpose of the project is to further understand the capabilities of Java classes and objects while practicing the use of object arrays.
 As with the previous project, one class is defined with constructors and methods to be used as a blueprint to create objects in another class.
*/

import java.util.Random;
import java.util.Scanner;

public class TestAccountAlcineus {

	public static void main(String[] args) {
		//Stage 1
		int[] accountIds = {9801, 2345, 3025, 1024, 4096, 6021, 8192, 5768, 7113, 1497};
		//Stage 2
		double[] accountBalances = new double[accountIds.length];
		Account[] accounts = new Account[accountIds.length];
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = new Account();
			accounts[i].setId(accountIds[i]);
			double rng = new Random().nextDouble();
			accountBalances[i] = 5000.01 * rng;
			accounts[i].setBalance(accountBalances[i]);
		}
		//Stage 3
		while (true) {
			Scanner input = new Scanner(System.in);
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$ Welcome! $$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println("Please enter the ID number of your account:");
			int inputId = input.nextInt();
			int accountNum = accounts.length;
			boolean validId = false;
			for (int i = 0; i < accountIds.length; i++) {
				if (inputId == accounts[i].getId()) {
					validId = true;
					accountNum = i;
					break;
				}
			}
			while (validId == false) {
				System.out.println("The entered ID number is invalid. Please try again:");
				inputId = input.nextInt();
				for (int i = 0; i < accountIds.length; i++) {
					if (inputId == accounts[i].getId()) {
						validId = true;
						accountNum = i;
						break;
					}
				}
			}
			//Stage 4
			System.out.println("The entered ID number is valid. Welcome!");
			while (true) {
				System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
				System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$ Main Menu $$$$$$$$$$$$$$$$$$$$$$$$$");
				System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
				System.out.println("                      1: Check Balance                      ");
				System.out.println("                      2: Withdraw                           ");
				System.out.println("                      3: Deposit                            ");
				System.out.println("                      4: Exit                               ");
				System.out.println("                      Enter an option:                      ");
				int option = input.nextInt();
				while (option < 1 || option > 4) {
					System.out.println("                      Please try again:                     ");
					option = input.nextInt();
				}
				System.out.println("------------------------------------------------------------");
				if (option == 1) {
					System.out.printf("Your balance is: %.2f\n", accounts[accountNum].getBalance());
				}
				else if (option == 2) {
					System.out.println("Enter an amount to withdraw:");
					double money = input.nextDouble();
					if (money > accounts[accountNum].getBalance()) {
						System.out.println("Not enough funds. Consider checking your balance.");
					}
					else {
						accounts[accountNum].withdraw(money);
						System.out.printf("%.2f withdrawn. Your new balance is: %.2f\n", money, accounts[accountNum].getBalance());
					}
				}
				else if (option == 3) {
					System.out.println("Enter an amount to deposit:");
					double money = input.nextDouble();
					accounts[accountNum].deposit(money);
					System.out.printf("%.2f deposited. Your new balance is: %.2f\n", money, accounts[accountNum].getBalance());
				}
				else {
					System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
					System.out.println("$$$$$$$$$$$$$$ Now ending session. Goodbye! $$$$$$$$$$$$$$$$");
					break;
				}
			}
			//There is no possible way to close a Scanner object in an infinite loop while having the loop continue. That resource leak warning will be there forever.
			//input.close();
		}
	}

}

class Account {
	private int id = 0;
	private double balance = 0;
	/*
	 This is a constructor that initializes a default account.
	 It allows a new account object without parameters to be created.
	*/
	public Account() {
	}
	/*
	 This is a constructor that initializes an account with a specified ID and balance.
	 It allows a new account object with parameters to be created.
	*/
	public Account(int id, double balance) {
	}
	/*
	 This type of method is known as an accessor, also known as a getter.
	 Using this getter, the id value of an account object is returned to the account class.
	*/
	public int getId() {
		return id;
	}
	/*
	 This type of method is known as an accessor, also known as a getter.
	 Using this getter, the balance value of an account object is returned to the account class.
	*/
	public double getBalance() {
		return balance;
	}
	/*
	 This type of method is known as a mutator, also known as a setter.
	 Using this setter, the id value of the account class is modified to the id value of an account object.
	*/
	public void setId (int id) {
		this.id = id;
	}
	/*
	 This type of method is known as a mutator, also known as a setter.
	 Using this setter, the balance value of the account class is modified to the balance value of an account object.
	*/
	public void setBalance (double balance) {
		this.balance = balance;
	}
	/*
	 This is a method that withdraws an amount of money from an account's balance.
	 It does so by setting the new balance equal to the old balance minus the amount.
	*/
	public void withdraw (double amount) {
		balance -= amount;
	}
	/*
	 This is a method that deposits an amount of money to an account's balance.
	 It does so by setting the new balance equal to the old balance plus the amount.
	*/
	public void deposit (double amount) {
		balance += amount;
	}
}