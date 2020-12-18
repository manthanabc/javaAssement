/***
to check if number is Armstrong

153= 1^3 + 5^3 + 3^3
153=  1  + 125 + 27

1634= 1^4 + 6^4 + 3^4 + 4^4
1634=  1  +1296 + 81  + 256

*/

import java.util.Scanner;
class armstrong
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.print("Enter your number -");
		
		int number =0,digits_in_number=0,sum=0;
		
		if(sc.hasNextInt()){
			number=sc.nextInt();
			if(number==0){System.out.print("invald");return;}
		}
		else{
			System.out.print("invald");
			return;
		}

		//calculates the number of digits
		int testNum=number;
		while (testNum >0)
		{
			digits_in_number++;
			testNum=testNum/10;
		}

		//refill the variable with value to use again
		testNum=number;
		System.out.println("number of digitsare "+digits_in_number);

		while(testNum >0)
		{
			int i=testNum%10;
			testNum/=10;
			sum+=(int)Math.pow(i,digits_in_number);
		}

		System.out.print((sum==number)?"yes armstrong":"no not armstrong");

	}
} // **************************************************************************************