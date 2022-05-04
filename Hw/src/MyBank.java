/*
 *		Name:			Lam, Simon		
 *		Project: 		#1
 *		Due:			October 19, 2012
 *		Course:			CS-141-01-f12
 *
 *		Description:
 *		MyBank is an extension of SavingsAccount. This program is user-
 *		friendly, where the user can input how much she or he wants to
 *		deposit and withdraw.
 *
 */
import java.util.Scanner;
import java.text.DecimalFormat;

public class MyBank extends SavingsAccount {

	public MyBank(double number) {
		super(number);
		// TODO Auto-generated constructor stub
	}

	public static void main (String [] args) {
		
		Scanner kb = new Scanner(System.in);
		DecimalFormat format = new DecimalFormat("#0.00");
		
		boolean forward = false;
		double deposit, withdraw;
		String y;
		
		System.out.println("Initial Balance?");
		double balance = kb.nextDouble();
		SavingsAccount sav1 = new SavingsAccount(balance);
		
		
		
		do {
			System.out.println("Would you like to make a deposit or withdraw? (Y/N)");
			y = kb.next();
			if ( y.equals("Y") || y.equals("y")) {
				System.out.println("Would you like to make a deposit or withdraw? (D/W)");
				y = kb.next();
				if( y.equals("D") || y.equals("d")) {
					System.out.println("Amount Deposit?");
					deposit = kb.nextDouble();
					sav1.makeDeposit(deposit);
					sav1.totalDeposit(deposit);
					sav1.numberDeposits();
				}else if( y.equals("W") || y.equals("w")){
					System.out.println("Amount Withdrawn?");
					withdraw = kb.nextDouble();
					sav1.makeWithdrawal(withdraw);
					sav1.totalWithdraw(withdraw);
					sav1.numberWithdrawal();
				}
			}else if( y.equals("N") || y.equals("n")){
				forward = true;
			}
		} while (forward != true);
		
		sav1.applyInterest();
		
		System.out.println();
		System.out.println("Welcome to jBank version 0.1\nCopyright (C) Simon-Lam 2012. All rights reserved.");
		System.out.println();
		
		System.out.println("Initial Balance = $" + format.format(balance) + ("."));
		System.out.println("Total Deposit   = $" + format.format(sav1.getTotalDeposit())+ ". (" + sav1.getNumberDeposit() + ")");
		System.out.println("Total Withdraws = $" + format.format(sav1.getTotalWithdraw())+ ". (" + sav1.getNumberWithdraw() + ")");
		System.out.println("Interest        = " + format.format(sav1.getInterest()) + ("%."));
		System.out.println("--------------------");
		System.out.println("BALANCE: $" + format.format(sav1.getBalance()));
		System.out.println();
	}
}
