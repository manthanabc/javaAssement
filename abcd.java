/**
to print -
A
BC
DEF
GHIJ
KLMNO
*/

class abcd
{
	public static void main(String[] args)
	{
		int rows=5;
		char start='A';
		int shift=0;
		for(int i=1;i<=5;i++)
		{
			for(int j=1;j<=i;j++)
			{
				System.out.print((char)((int)start+shift));
				shift++;
			}
			System.out.println();
		}
	}
}