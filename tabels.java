/** 
		print tabels from one to 15teen
*/

class tables
{
	public static void main(String[] args) 
	{
		for(int i=1;i<=15;i++)
		{
			System.out.println("\n\n"+i+"\'s table is -\n");
			for(int j=1;j<10;j++){
				System.out.println(i+" x "+j+" = "+(i*j));
			}
		}	
	}
}