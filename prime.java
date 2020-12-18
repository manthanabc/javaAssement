/**
		checking if input number is prime or not 
*/

import java.util.Scanner;
class prime
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);

		System.out.println("Enter the number");

		int number=0;

		if(sc.hasNextInt())
			number=sc.nextInt();
		else{
			System.out.println("Invalid");
			return;
		}

		for(int i=2;i<number;i++)
		{
			if(number%i==0){
				System.out.println("not prime");
				return;
			}
		}
		System.out.println("yes its prime");
	}
}