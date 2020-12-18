/** 
			printing largest of four names

*/

//importing scanner class to take input
import java.util.Scanner;


class largest
{
	//main method which will be executed
	public static void main(String[] args)
	{
		//creating an scanner object to take input
		Scanner scanner=new Scanner(System.in);

		System.out.println("Enter four numbers seprated by space-");

		float n1=0,n2=0,n3=0,n4=0;

		if(scanner.hasNextFloat()){
			n1=scanner.nextFloat();
		}
		if(scanner.hasNextFloat()){
			n2=scanner.nextFloat();
		}
		if(scanner.hasNextFloat()){
			n3=scanner.nextFloat();
		}
		if(scanner.hasNextFloat()){
			n4=scanner.nextFloat();
		}
		else{
			System.out.println("Invalid, number must be real numbers only and nothing else is acceptable");
			return;
		}
	
		System.out.println("\n Your numbers are "+" "+n1+" "+n2+" "+n3+" "+n4);
		System.out.print("     ");

		if(n1>n2&&n1>n3&&n1>n4)
			System.out.println(n1+" "+"is greatest");

		if(n2>n1&&n2>n3&&n2>n4)
			System.out.println(n2+" "+"is greatest");

		if(n3>n2&&n3>n1&&n3>n4)
			System.out.println(n3+" "+"is greatest");

		if(n4>n2&&n4>n1&&n4>n3)
			System.out.println(n4+" "+"is greatest");

	}
}