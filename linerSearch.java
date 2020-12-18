/** this performs a linear search on given numbers*/

import java.util.Scanner;
class linerSearch
{
	public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
		System.out.print("Enter how many numbers you want to search - ");
		
		int size=0;
		if(scan.hasNextInt())
			size=scan.nextInt();
		else{System.out.print("invalid");return;}

		float nums[]=new float[size];
		
		System.out.println("Enter the numbers -");
		for(int i=0;i<size;i++)
			if(scan.hasNextFloat())
			nums[i]=scan.nextFloat();
			else{System.out.print("invalid");return;}


		System.out.print("Enter the tearm you want to search - ");		
		float search_num=0;
		if(scan.hasNextFloat())
			search_num=scan.nextFloat();
		else{System.out.print("invalid");return;}


		int found=0;
		for(int i =0;i< size;i++)
		{
			if(nums[i]==search_num)
			{
				System.out.println("found at index "+i+ " i.e "+(i+1)+((i+1==1)?"st":(i+1==2)?"nd":((i+1==3)?"rd":"th"))+" term.\n do you want \'c\' to continue searching for more numbers?y for yes");
				found++;
				char ch=scan.next().charAt(0);
				if(ch=='y'){}
				else return;
			}
		}

		System.out.printf((found ==  0)?"Found nothing":"Finished found "+found+" matching numbers");
	}
}