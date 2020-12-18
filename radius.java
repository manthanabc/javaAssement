/**
			taking radius and printing circumfernce and aread
*/

//importing scanner class to take input
import java.util.Scanner;


class circle
{
	//main method which will be executed
	public static void main(String[] args)
	{
		//creating an scanner object to take input
		Scanner scanner=new Scanner(System.in);

		System.out.print("Enter the radius in cm -");

		float radius,area,circum;
		final float PI=3.1415926535897f;

		while (true)
		{	
			if(scanner.hasNextFloat()) 
			{
				radius=scanner.nextFloat();
				
				if(radius <0)
				{
					System.out.println("must be positive");
					continue;
				}

				if(radius==0)
				{
					System.out.println("Circumference is 0 and area is 0");
					return;
				}

				if(radius>0){break;}

			}
			else
			{
				System.out.println("Invalid input");
				return;
			}

		}

		System.out.println("\n\nYour input Radius is "+radius+" cm");
		area=PI*radius*radius;
		circum=2*PI*radius;
		System.out.println("\nCircumference is "+circum+" cm area is "+area+" cm^2");
	}
}