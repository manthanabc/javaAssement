/** takes input and performs a bubble sort */

import java.util.Scanner;
class bubbleSort
{
	public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
		System.out.print("Enter how many numbers you want to sort - ");
		
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

		nums=bubbleSort(nums);
		System.out.println("Sorted aray is -");
		for(float n:nums)
			System.out.print(" "+n+" ");

	}

	public static float[] bubbleSort(float[] unsorted)
	{
		float[] sorted=unsorted;

		for(int i=0;i<sorted.length;i++)
		{
			for (int j=1;j<sorted.length-i;j++) {
				//System.out.print("checking "+i+' '+j);
				if(sorted[j] < sorted[j-1])
				{
					//System.out.println(sorted[j]+"=="+sorted[j-1]);
					sorted[j]+=sorted[j-1];
					sorted[j-1]=sorted[j]-sorted[j-1];
					sorted[j]=sorted[j]-sorted[j-1];
					//System.out.println(sorted[j]+"=="+sorted[j-1]);
				}

			}
		}
		return sorted;

	}

}
