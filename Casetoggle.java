/**

toggle the case of input word 
input = aBcD
output = AbCd

*/
import java.util.*;
class toggle
{
	public static void main(String[] args)
	{
		Scanner sn=new Scanner(System.in);
		
		System.out.print("Enter string");
		
		String s="";

		if(sn.hasNext())
			s=sn.next();
		else {
			System.out.println("invalid");
			return;
		}

		for(int i=0;i<s.length();i++){
			System.out.print(((int)s.charAt(i)>='A'&&(int)s.charAt(i)<='Z')?(char)((int)s.charAt(i)+32):((int)s.charAt(i)>='a'&&(int)s.charAt(i)<='z')?(char)((int)s.charAt(i)-32):s.charAt(i));
		}
	}
}