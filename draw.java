/**
calss draw 
*/
class drawer
{

	public void draw()
	{
		for(int i=0;i<10;i++)
			System.out.print("NPS\t");
	}

	public void draw(int n,char s)
	{
		for(int i=0;i<n;i++)
			System.out.print(s+"\t");
	}

	public void draw(int n)
	{
		for(int i=0;i<n;i++)
			System.out.print("*\t");
	}

	public void draw(int n,String s)
	{
		for(int i=0;i<n;i++)
			System.out.print(s+"\t");
	}

	public static void main(String[] args)
	{
		drawer draw=new drawer();
		draw.draw();
		draw.draw(10);
		draw.draw(10,"t");
		draw.draw(10,'t');
	}
}