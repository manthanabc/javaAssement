/**
taking an operation performing it on two numbers
*/ 



//importing scanner class to take input
import java.util.Scanner;


class arithmatic
{
	//main method which will be executed
	public static void main(String[] args)
	{
		//creating an scanner object to take input
		Scanner scanner=new Scanner(System.in);
		System.out.println("use +(addition) ,-(substraction) ,*(multiplication) ,/(divition) ,%(modulus(remender)) ");

		char choice=' ';

		if(scanner.hasNext())
		{
			choice=scanner.next().charAt(0);
			if(choice=='+'||choice=='-'||choice=='*'||choice=='/'||choice=='%'){}
			else{
				System.out.println("invalid");
				return;
			}
		}


		float a,b,ans;

		//initializing a
		System.out.println("Enter first number");
		if(scanner.hasNextFloat()) a=scanner.nextFloat();
		else {System.out.println("invalid"); return;}

		//initializing b
		System.out.println("Enter Second number");
		if(scanner.hasNextFloat()) b=scanner.nextFloat();
		else {System.out.println("invalid"); return;}

		System.out.print(a+" "+choice+" "+b +" is ");
		switch(choice)
		{
			case '+':System.out.println(a+b);break;
			case '-':System.out.println(a-b);break;
			case '*':System.out.println(a*b);break;
			case '%':System.out.println(a%b);break;
			case '/':if(a>0 && b>0)System.out.println(a/b);else return;break;
			default:System.out.println("something went wrong try again");
		}

	}
}

