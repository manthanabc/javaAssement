/**
	Menu driven program to print 
	series 0 1 1 2 3 .... (input) 
	i.e n(number) = (n=n-2) + (n-1)
	or to print 
	series 1  1/2 1/3 1/4 .... 1/input
	i.e n(number) = 1/n
*/

import java.util.*;
class series
{
	public static void main(String[] args)
	{
		Scanner sn=new Scanner(System.in);
		System.out.println("\nEnter one to print -\n\t series 0 1 1 2 3 .... (input) \nEnter two to print -\n\t series 1  1/2 1/3 1/4 .... 1/(input) \n\nEnter 3 to exit");
		pro:while(true)
		{
			System.out.print("\n-");
			if(sn.hasNextInt()){

			}else{
				System.out.println("invalid choice");
				continue;
			}
			switch(sn.nextInt())
			{
				case 1:System.out.println("series is -");
						int n=2,ppx=0,px=1;
						System.out.print("enter n -");
						if(sn.hasNextInt())
						   n=sn.nextInt();
						
						if(n<=2)
						{
							if (n<0){	
								System.out.println("invalid");
								continue;
							}
							System.out.println((n==1)?ppx+"\t":ppx+"\t"+px+"\t");
							continue;
						}
						System.out.print(ppx+"\t"+px+"\t");
						for(int i=0;i<=n-3;i++){
							System.out.print(ppx+px+"\t");
							px++;
							ppx++;
						}
						break;
				case 2:System.out.println("dum dum");
						System.out.print("Enter n-");
						n=0;
						if(sn.hasNextInt())
							n=sn.nextInt();
						if(n<1){
							System.out.println("number greater then 0");
							continue;
						}
						for(int i=1;i<n+1;i++)
						{
							System.out.print(1+"/"+i+"\t");
						}

						System.out.println();

						for(int i=1;i<n+1;i++)
						{
							System.out.print(1.0/i+"\t");
						}

						break;
				case 3:System.out.println("cya");break pro;
			}
		}
	}
}