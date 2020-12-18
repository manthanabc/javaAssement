/** print all nmbers between given range **/

import java.util.*;
class range
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter two numbers seprated by space-");
		int n1=0,n2=0;
		if (scan.hasNextInt())
			n1=scan.nextInt();
		else{
			System.out.println("invalid");
			return;
		}

		if(scan.hasNextInt())
			n2=scan.nextInt();
		else{
			System.out.println("invaild");
			return;
		}

		System.out.println("range -");

		if(n2>n1)
			for(;n1<=n2;n1++)
				System.out.print(n1);
		else
			for(;n1>=n2;n1--)
				System.out.print(n1);
	}
}