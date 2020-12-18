/**
this program printsthe following pattern
1
12
123
12
1
*/
class pattern
{
	public static void main(String[] args)
	{
		int numbers=3;

		//from one to number
		for(int i=1;i<=numbers;i++)
		{
			for (int j=1;j<=i;j++) {
				System.out.print(j);
			}
			System.out.println();
		}

		//from number to one
		for(int i=numbers-1;i>0;i--)
		{
			for (int j=1;j<=i;j++) {
				System.out.print(j);
			}
			System.out.println();
		}
	}
}