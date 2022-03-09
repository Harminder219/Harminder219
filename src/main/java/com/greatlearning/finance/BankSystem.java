package com.greatlearning.finance;

import java.util.Scanner;

public class BankSystem {
	
	static int generatedotpfromsystem()
	{
		return (int) (Math.random()*9000+1000);
	}

	public static void main(String[] args) {

		String customerAccountNumber="A8833";
		String customerPassword="pass";
		int customerBalance=1000;


		int amount,choice,otp,generatedOtp;
		String otheraccno;

		Scanner scanner=new Scanner(System.in);

		boolean flag;

		do {

			System.out.println("Please enter the Account number:");
			String customerAccnum=scanner.nextLine();
			
			System.out.println("Please enter the Password:");
			String customerpass=scanner.nextLine();
			
			
			

			if(customerAccountNumber.equals(customerAccnum)  && customerPassword.equals(customerpass))
			{
				System.out.println("You are successfully logged in");
				flag=false;
				
				
			}
			
			else {
				System.out.println("Please enter the corrrect account number and password");
				System.out.println();
				flag=true;

			}


		} while (flag);
		
		
		do {
			System.out.println("\nPlease enter your choice:\n 1.Deposit \n 2.Withdraw \n 3.Transfer \n 4.Logout");
			choice=scanner.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("\nPlease enter the amount to deposit:");
				amount=scanner.nextInt();
				customerBalance+=amount;
				System.out.println("\nAccount balance after deposit:"+customerBalance);
				break;
				
			}
			case 2:
			{
				System.out.println("\nPlease enter the amount to withdraw:");
				
				amount=scanner.nextInt();
				if(amount > customerBalance)
				{
					System.out.println("\nInsufficient account balance");	
				}
				else {
					customerBalance-=amount;
					System.out.println("\nAccount balance after withdraw:"+customerBalance);
					
				}
				break;
				
			}
			case 3:
			{
				System.out.println("\nPlease enter the account number and amount to transfer:");
				otheraccno=scanner.nextLine();
				amount=scanner.nextInt();
				otp=generatedotpfromsystem();
				System.out.println("OTP:"+otp);
				System.out.println("\n Please enter OTP : ");
				generatedOtp=scanner.nextInt();
				if(generatedOtp==otp)
				{
						
					if(amount > customerBalance)
					{
						System.out.println("\nInsufficient account balance");	
					}
					else {
						customerBalance-=amount;
						System.out.println("\nAccount balance after transfer:"+customerBalance);
						
					}
				}
				else {
					System.out.println("\nInvalid otp , please try again");	
				}
				
				break;
				
				
			}
			case 4:
			{
				 System.out.println("You are logged out");
				 flag=true;
				 break;
				
			}
			default:
				 System.out.println("Please enter the valid choice.");
			}
			
		} while (!flag);



	}

}
