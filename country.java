// take 10 country names and arrange them in decending order by len 

import java.util.*;
class countrySorter
{
	public static void main(String[] args)
	{
		Scanner sn=new Scanner(System.in);
		int noOfCountrys=10;
		String [] countries=new String[noOfCountrys];

		for(int i=0;i<noOfCountrys;i++)
			if(sn.hasNext())
				countries[i]=sn.next();
			else{
				System.out.print("invaid input");
				return ;
			}

		System.out.println("taen in");

		for(int i=0;i<noOfCountrys;i++)
			for(int j=1;j<noOfCountrys-i;j++)
			{
				if(countries[j].length()>countries[j-1].length()){
					String tem=countries[j];
					countries[j]=countries[j-1];
					countries[j-1]=tem;
				}
			}


		System.out.println("\n\nSorted list- \n\n");
		for(String country:countries)
		System.out.println(country);
	}
}