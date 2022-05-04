/*
 *		Name:			Lam, Simon		
 *		Project: 		#1
 *		Due:			October 19, 2012
 *		Course:			CS-141-01-f12
 *
 *		Description:
 *		SavingsAccount project implements the multitude of different methods 
 *		that when called upon performs different behaviors. I implement the
 *		mutators and accessor methods to assign values and attain the value
 *		that has been stored in a field. My fields consist of: totalDeposit,
 *		totalWithdraw, numberDeposit, numberWithdraw, balance, and interest.
 *		My behaviors/methods consists of setting the values for the balance,
 *		determining the amount of deposits and withdrawals that has been made,
 *		and summing up the total deposits and withdrawals.
 *
 */

import java.util.Scanner;
import java.io.*;
import java.text.DecimalFormat;

public class SavingsAccount {
	
	private double totalDeposit, totalWithdraw, balance;
	private int numberDeposit, numberWithdraw;
	private double interest = 1;
	
	/**
	 * The getBalance method returns the account's balance.
	 * @return The value in the balance field.
	 */
	public double getBalance() {
		return balance;
	}
	
	/**
	 * The getInterest method that returns the account's 
	 * interest rate.
	 * @return The value in the interest rate field.
	 */
	public double getInterest() {
		return interest;
	}
	
	/**
	 * The getTotalWithdraw method that returns the 
	 * account's total amount withdrawn.
	 * @return The value in the total withdrawn field.
	 */
	public double getTotalWithdraw() {
		return totalWithdraw;
	}
	
	/**
	 * The getTotalDeposit method returns the value of 
	 * total deposit that has been deposited into the 
	 * account's bank.
	 * @return The value in the total deposit field.
	 */
	public double getTotalDeposit() {
		return totalDeposit;
	}
	
	/**
	 * The getNumberDeposit method returns the value of
	 * the total amount of deposits that were done.
	 * @return The value in the number of deposit field.
	 */
	public int getNumberDeposit() {
		return numberDeposit;
	}
	
	/**
	 * The getNumberWithdraw method returns the value of
	 * the total amount of withdraws that were done.
	 * @return The value in the number of withdraws field.
	 */
	public int getNumberWithdraw() {
		return numberWithdraw;
	}

	/**
	 * The makeDeposit method that sets the new amount in
	 * the balance field after a deposit has been made. The
	 * deposit is added to the old balance producing a new
	 * and updated balance.
	 * @param deposit The amount to add to the balance field,
	 * 				  introduced as a double type.
	 */
	public void makeDeposit(double deposit) {
		balance += deposit;
	}
	
	/**
	 * The makeWithdrawal method sets the new amount in the
	 * balance field after a withdrawal has been made. The
	 * withdrawal is subtracted from the original balance,
	 * updating the balance to a more recent and lesser value
	 * balance.
	 * @param withdraw The amount to subtract from the balance
	 * 				   field, introduced as a double type.
	 */
	public void makeWithdrawal(double withdraw) {
		balance -= withdraw;
	}
	
	/**
	 * The totalWithdraw method sums all withdrawn amount 
	 * to a total withdraw field. This method sets the field
	 * to a more recent and updated amount of withdrawn.
	 * @param withdraw The value that is added to the total
	 * 				   withdrawn field, introduced as a double.
	 */
	public void totalWithdraw(double withdraw) {
		totalWithdraw += withdraw;
	}
	
	/**
	 * The totalDeposit method sums all deposited amount
	 * to a total deposit field. This method adds the recent
	 * deposit to the original total deposit, setting a new
	 * value for total deposit field.
	 * @param deposit This value is added to the total deposit
	 * 				  field, introduced as a double.
	 */
	public void totalDeposit(double deposit) {
		totalDeposit += deposit;
	}
	
	/**
	 * This applyInterest method adds the interest amount to
	 * the original balance, causing the balance to increase
	 * and be updated. This method sets a new value for the 
	 * balance field.
	 */
	public void applyInterest() {
		balance = balance + (balance * (interest / 100.00));
	}
	
	/**
	 * This numberDeposits method counts the number of times
	 * a deposit has been made. This method sets a value to
	 * the number of deposits field.
	 */
	public void numberDeposits() {
		numberDeposit++;
	}
	
	/**
	 * This numberWithdrawal method counts the number of times
	 * a withdrawal has been made. This method sets a value to
	 * the number of withdrawal field.
	 */
	public void numberWithdrawal() {
		numberWithdraw++;
	}
	
	public SavingsAccount(double number){
		balance = number;		
	}

	public static void main (String[] args) throws IOException {
		
		DecimalFormat formatter = new DecimalFormat("#0.00");
		File depositFile = new File("Deposits.txt");
		Scanner inputFile1 = new Scanner(depositFile);
		File withdrawFile = new File("Withdrawals.txt");
		Scanner inputFile2 = new Scanner(withdrawFile);
		
		SavingsAccount sav = new SavingsAccount(500);
		
		System.out.println();
		System.out.println("Welcome to jBank version 0.1\nCopyright (C) Simon-Lam 2012. All rights reserved.");
		System.out.println();
		
		System.out.println("Initial balance = $" + formatter.format(sav.getBalance()));
		
		do{ //deposits
			double dep = inputFile1.nextDouble();
			sav.makeDeposit(dep);
			sav.totalDeposit(dep);
			sav.numberDeposits();
		} while (inputFile1.hasNext());
		
		do{ //withdraws
			double with = inputFile2.nextDouble();
			sav.makeWithdrawal(with);
			sav.totalWithdraw(with);
			sav.numberWithdrawal();
		} while (inputFile2.hasNext());
		
		sav.applyInterest();
		
		System.out.println("Total Deposits  = $" + formatter.format(sav.getTotalDeposit()) + ". (" + sav.getNumberDeposit() + ")");
		System.out.println("Total Withdraws = $" + formatter.format(sav.getTotalWithdraw()) + ". (" + sav.getNumberWithdraw() + ")");
		System.out.println("Internet        = " + formatter.format(sav.getInterest()) + "%.");
		System.out.println("------------------");
		System.out.println("BALANCE:  $" + formatter.format(sav.balance));
		
	}
}
