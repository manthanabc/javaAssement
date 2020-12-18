/**
Calculate bounus and net salary
<25k    bonus=45%

>25k and <=50k  boonus=25%

>50k    bonus = 15%

*/
import java.util.Scanner;
class bonus
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your salary");
		
		float salary=0,bonus=0;

		if(sc.hasNextFloat())
		{
			salary=sc.nextFloat();
			if(salary == 0)
			{
				System.out.print("thas invalid"); 
				return;
			}
		}

		else{
			System.out.println("Invalid input");
			return;
		}

		if(salary <= 25000)
			bonus=0.45f*salary;

		else if(salary <= 50000)
			bonus=0.25f*salary;

		else if(salary > 50000)
			bonus=0.15f*salary;
		else 
			System.out.println("something went wrong");

		System.out.println("YOur bonus is "+bonus+" total pay is "+(salary+bonus));
	}
}