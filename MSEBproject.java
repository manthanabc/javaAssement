// 10th project name:manthan patil 
/**
class mseb to accept an customer number , name,addres,
connectiontype ,birthdate,previous reading ,current reading 
and show the fix charge,electriccharges used and print net amount


variable table -
----------------------------------------------------------------------------------------------
data Members			meaning

long Cnumber			Customer Number
String Cname			Customer Name
String CAddress			Customer Adress
Srting Conntype 		Conntype (Domestic or Commerical)
String Bdate 			Custommer billhdate
int Prevreading			Customer's previous reading
int Curreading			Customer's current reading
int Totalunit 			Customers total reading

double Fixrate			fied rate according to Connectiontype
double Eleccharge  		Customers electricity charge according to unit consumed
double Carrycharge 		Customers carrcharge charge according to unit consumed(1.45 RS/unit)
double Netamt 			All charges added together(fixrate+eleccharge+CarryCharge+netAmt)
boolean Calculated		keeps track if the total is calulated  before printing
-----------------------------------------------------------------------------------------------
*/

//importing the Scanner class form util package to take input from users kyboard
import java.util.Scanner;


class MSEB
{
	//Declaring the data members
	long Cnumber;
	String Cname,CAdress,Conntype,BDate;
	int Prevreading,Curreading,Totalunit;
	double Fixrate,Eleccharge,Carrycharge,Netamt;
	boolean Calculated;

	//taking the values and assing them to appropreate variables
	void accept()
	{

		//Creatng an scanner object to take inputs
		Scanner scn = new Scanner(System.in);
		
		//inputing the name
		System.out.print("Enter customer name    -");
		if(scn.hasNextLine())
			Cname = scn.nextLine();
		else 
			printError(": invail name");

		//inputing the number
		System.out.print("Enter customer number   -");
		if(scn.hasNextLong())
			Cnumber = scn.nextLong();
		else 
			printError(": invaild customer number");

		
		scn.nextLine();        //finishing the last line read

		//inputing the address
		System.out.print("Enter customer address  -");
		if(scn.hasNextLine())
			CAdress = scn.nextLine();
		else 
			printError(": worng address");

		//inputing the connection type
		System.out.print("Enter customer's connection\n type (either Domestic(D) or Commerical (C))-");
		if(scn.hasNext())
			Conntype = scn.nextLine();
		else
			printError(": wrong connection type");
		
		//editing the conn type
		if(Conntype.charAt(0) == 'C' || Conntype.charAt(0) == 'c')
			Conntype="c";
		if(Conntype.charAt(0) == 'D' || Conntype.charAt(0) == 'd')
			Conntype = "d";
		if(Conntype != "c" && Conntype!="d")
			printError(": Conntype must be Domestic or Commerical");

		//inputing the bill date
		System.out.print("Enter customer bill date (format (dd/mm/yy)) -");
		if(scn.hasNext()){

			BDate = scn.next();
			
			//Checking if the date is valid
			if (!validDate(BDate))
				printError(": invalid date or wrong date format");
		
		}else 
			printError("");

		//inputing the previous reading
		System.out.print("Enter customer's previous reading -");
		if(scn.hasNextInt())
			Prevreading = scn.nextInt();
		else
			printError(": invaild reading");
		if(Prevreading<0)
			printError(": reading must be greater than 0");


		//inputing the current reading
		System.out.print("Enter customer's current reading -");
		if(scn.hasNextInt())
			Curreading = scn.nextInt();
		else
			printError(": invalid reading");
		
		//testing if its greater than 0
		if(Curreading<0)
			printError(": reading must be greater than 0");

		if(Curreading < Prevreading)
			printError(": check your Previous reading and current reading as current reading cannot be less than Previus reading");

		//seting calculated to false as we just took input 
		Calculated=false;
	}

	//Calculating the Netamt,fixrate,Elecharge,Carrycharge
	void calculate()
	{
		//assigning the fixedrate based of conntype
		Fixrate = (Conntype=="d")?110:310;
		Totalunit = Curreading - Prevreading;

		//Calclulating the Eleccharge base on Totalunit
		if(Totalunit < 101)
			Eleccharge = 3.46;
		else if(Totalunit < 301)
			Eleccharge = 7.43;
		else if(Totalunit < 501)
			Eleccharge = 10.32;
		else if(Totalunit < 1001)
			Eleccharge = 11.71;
		else 
			Eleccharge = 12.0;

		//multiply Eleccharge with total unit 
		Eleccharge*=Totalunit;

		//Calculating the carrycharge
		Carrycharge = 1.45*Totalunit;

		//Calculating the Netamt
		Netamt = Carrycharge+Eleccharge+Fixrate;

		//seting the caluated true as we just calculated
		Calculated = true;
	}

	//displays the values in table format
	void Display()
	{
		//checks if calculations are done 
		if(!Calculated)
			System.out.print("net amound is not yet Calculated.first calculate and then try again");

		//varibale for setting the charchter per line of terminal (default is 80)
		int windowWidth = 80;
		//spaces between the words and the number
		int spaces = 22;
		
		//making space for the output
		System.out.println("\n\n\n");

		//printing the heading
		String heading="MSEB Dhule";
		for(int i=0;i < (int)((windowWidth-heading.length())/2);i++)
			System.out.print(" ");
		System.out.println(heading);
		
		//print the start line of box on terminal
		for(int i = 0;i<windowWidth;i++)
			System.out.print("-");

		String[] words={"Consumer Number","Consumer Name","Consumer Adress","Consumer type","Consumer Bill Date","Previous Reading","Current Reading","Total units","Fix Charge","Electric Charge","Carry Charges","Net Amt"};


		//printing the Consumer number
		System.out.print(" "+words[0]);
		for(int i=0;i<spaces-words[0].length();i++)
			System.out.print(" ");
		System.out.println(": "+Cnumber);

		//Printing the Consumer name
		System.out.print(" "+words[1]);
		for(int i=0;i<spaces-words[1].length();i++)
			System.out.print(" ");
		System.out.println(": "+Cname);

		
		//Printing the Consumer address

		System.out.print(" "+words[2]);
		//adding required spaces
		for(int i=0;i<spaces-words[2].length();i++)
			System.out.print(" ");
		//if the address is greater than how much can fit in one line print sace before each segment
		if(CAdress.length() > windowWidth-26)
		{
			System.out.print(": "+CAdress.substring(0,windowWidth-25));
			for(int i = 1; i <= Math.ceil((CAdress.length())/(windowWidth-26));i++){
				for(int j=0;j<spaces-words[2].length()+18;j++)
					System.out.print(" "); 
				System.out.print(CAdress.substring(i*(windowWidth-25),(i+1 <=  Math.ceil((CAdress.length())/(windowWidth-26)))?(i*(windowWidth-25)+1)+windowWidth-26:CAdress.length()));
			}

			//putting curser to net line
			System.out.println();

		}
		else
			System.out.println(": "+CAdress);


		//Printing the Consumer type
		System.out.print(" "+words[3]);
		for(int i=0;i<spaces-words[3].length();i++)
			System.out.print(" ");
		System.out.println(": "+((Conntype == "d")?"Domestic":"Commerical"));

		//Printing the bill date 
		System.out.print(" "+words[4]);
		for(int i=0;i<spaces-words[4].length();i++)
			System.out.print(" ");
		System.out.println(": "+BDate+" ["+StringToDate(BDate)+"]");


		//Printing a line
		for(int i = 0;i<windowWidth;i++)
			System.out.print("-");

		//print Previous Reading: _____  Current Reading: _______ Total Units: ______ with apropreate spacing in between
		//calculating the spacing
		int spaceBetwWords =windowWidth-(9+words[5].length()+words[6].length()+words[7].length()+NumLength(Prevreading)+NumLength(Curreading)+NumLength(Totalunit));
		int startSpace,midSpace,endSpace;
		midSpace = (int)(spaceBetwWords*0.4);
		endSpace = midSpace;
		startSpace = (int)(spaceBetwWords * 0.1);
		
		//Printing the previous reading
		for(int i=0;i<startSpace;i++)
			System.out.print(" ");
		System.out.print(words[5]+" : "+Prevreading);

		//Printing the Current Reading
		for(int i=0;i<midSpace;i++)
			System.out.print(" ");
		System.out.print(words[6]+" : "+Curreading);

		//printing the total unit
		for(int i=0;i<endSpace;i++)
			System.out.print(" ");
		System.out.print(words[7]+" : "+Totalunit);

		//finishing the line
		System.out.println();

		//Printing a line
		for(int i = 0;i<windowWidth;i++)
			System.out.print("-");


		//printing the Fixed charges
		System.out.print(" "+words[8]);
		for(int i=0;i<spaces-words[8].length();i++)
			System.out.print(" ");
		System.out.println(": Rs "+Fixrate+".");

		//Printing the Electrc charges
		System.out.print(" "+words[9]);
		for(int i=0;i<spaces-words[9].length();i++)
			System.out.print(" ");
		System.out.println(": Rs "+Eleccharge+".");

		//Printing the Carry charges
		System.out.print(" "+words[10]);
		for(int i=0;i<spaces-words[10].length();i++)
			System.out.print(" ");
		System.out.println(": Rs "+Carrycharge+".");

		//Printing the net amount
		System.out.print(" "+words[11]);
		for(int i=0;i<spaces-words[11].length();i++)
			System.out.print(" ");
		System.out.println(": Rs "+Netamt+".");


		//Printing a line
		for(int i = 0;i<windowWidth;i++)
			System.out.print("-");


		//printing the net amount in words
		String SNetAmt="Rs "+NumToString((int)Math.round(Netamt))+" only.";
		int space=(int)Math.round((windowWidth-SNetAmt.length())/2);
		for(int i=0;i<space;i++)
			System.out.print(" ");
		System.out.println(SNetAmt);

	}

	//converts the string to number
	private int StringToNum(String word)
	{
		//converts string to number by bubtracting 48 (as ascii of 0 is 48)
		int num=0;

		//appends the digit to number 
		for(int i=0;i<word.length();i++)
		{
			num=num*10+(int)word.charAt(i)-48;
		}
		//returns the number
		return num;
	}

	//calculate the nmber of digits 
	private int NumLength(int n)
	{
		int number=0;
		while (n!=0)
		{
			n=n/10;
			number++;
		}
		return number;
	}

	//Converts string to date eg("01/11/12" => "1st november 2012")
	private String StringToDate(String raw_date)
	{
		if(validDate(raw_date))
		{
			String date="";
			int day = StringToNum(raw_date.substring(0,2));
			int month = StringToNum(raw_date.substring(3,5));
			int year = StringToNum(raw_date.substring(6,8));
			date=date+(day+((day == 1)?"st ":(day == 2)?"nd ":(day == 3)?"rd ":"th "));
			switch(month){
				case 1:date=date+"January";break;
				case 2:date=date+"Febuary";break;
				case 3:date=date+"March";break;
				case 4:date=date+"April";break;
				case 5:date=date+"May";break;
				case 6:date=date+"June";break;
				case 7:date=date+"Jully";break;
				case 8:date=date+"Agust";break;
				case 9:date=date+"September";break;
				case 10:date=date+"Octomber";break;
				case 11:date=date+"November";break;
				case 12:date=date+"December";break;
			}
			date=date+" 20"+raw_date.substring(6,8);
			return date;
		}else
			printError(": invaild date");
			return("");
	}

	//converts number to word string(123 => "One Hunderd Twenty Three")
	private String NumToString(int x)
	{
		//converting the number to array
		String out="";
		int[] digits=new int[NumLength(x)];
		for(int i=0;i < digits.length;i++){
			digits[i]=x%10;
			x=x/10;
		}

		//reversing the order
		for(int i=0;i<digits.length;i++){
			int temp=digits[i];
			digits[i]=digits[digits.length-i-1];
			digits[digits.length-i-1]=temp;
		}


		//adding the first digit (one's place)
		if(digits.length>0)
			if(digits.length > 1){
				if(digits[1]!=1)
					out=oneToNine(digits[0]);
			}
			else
				out=oneToNine(digits[0]);

		//adding the second digit (ten's place)
		if(digits.length>1)
			out=TenToHundread(digits[1],digits[0])+" "+out;
		
		//adding the third digit (Hundread's place)
		if(digits.length>2)
			out=oneToNine(digits[2])+((digits[2]>0)?" Hunderd "+out:""+out);


		//adding the fourth digit (Thousand's place)
		if(digits.length>3){
			if(digits.length>4){
				if(digits[4]!=1)
					out=NumToString(digits[3])+((digits[3]!=0)?" Thousand "+out:""+out);
				else
					out=(digits[3]!=0)?" Thousand "+out:out;
			}
			else
				out=NumToString(digits[3])+" Thousand "+out;
		}


		//adding the fifth digit(Ten Thousand's palce)
		if(digits.length>4)
			if(digits[3]==0)
				out=TenToHundread(digits[4],digits[3])+((digits[4]!=0)?" Thousand "+out:""+out);
			else
				out=TenToHundread(digits[4],digits[3])+" "+out;


		//adding the sixth place (Carod's place)
		if(digits.length>5){
			if(digits.length>6){
				if(digits[6]!=1)
					out=NumToString(digits[5])+((!(digits[5]==0))?" Carod "+out:"");
				else
					out=" Carod "+out;
			}
			else
				out=NumToString(digits[3])+" Carod "+out;
		}


		//adding the seventh place(ten Carod's place)
		if(digits.length>6)
			if(digits[5]==0)
				out=TenToHundread(digits[6],digits[5])+" Carod "+out;
			else
				out=TenToHundread(digits[6],digits[5])+out;

		if(digits.length>7)
			printError("too big number Total amount must be less than 100 corad to be printable");

		return out;
	}

	private String oneToNine(int n)
	{
		String out="";
		switch(n)
		{
			case 0:out="";break;
			case 1:out="One";break;
			case 2:out="Two";break;
			case 3:out="Three";break;
			case 4:out="Four";break;
			case 5:out="Five";break;
			case 6:out="Six";break;
			case 7:out="Seven";break;
			case 8:out="Eight";break;
			case 9:out="Nine";break;
		}
		return out;
	}

	private String TenToHundread(int thes,int last)
	{
		String out="";
		switch(thes)
		{
			case 0:out=""+out;break;
			case 1:out=(last==0)?"Ten"
					:(last==1)?"Eleven"
					:(last==2)?"Twelve"
					:(last==3)?"Thirteen"
					:(last==4)?"Fourteen"
					:(last==5)?"Fifteen"
					:(last==6)?"Sixteen"
					:(last==7)?"Seventeen"
					:(last==8)?"Eighteen"
					:(last==9)?"Nineteen":"";break;
			case 2:out="Twenty"+out;break;
			case 3:out="Thirty"+out;break;
			case 4:out="Fourty"+out;break;
			case 5:out="Fifty"+out;break;
			case 6:out="Sixty"+out;break;
			case 7:out="Seventy"+out;break;
			case 8:out="Eighty"+out;break;
			case 9:out="Ninty"+out;break;
		}

		return out;
	}


	//checks if char is number
	private boolean isNub(char n)
	{
		if((int)n >= 48 && (int)n < 58)
			return true;
		return false;
	}

	//returns true or false if date eists ot not
	private boolean validDate(String date)
	{
		//testing if the len is 8 as (dd/mm/yy) has 8 characters
		if(date.length()!=8)
			return false;

		//testing if the slash(/) is present at right place
		if(date.charAt(2)!='/' || date.charAt(5)!='/' || !(StringToNum(date.substring(0,2))<32) || !(StringToNum(date.substring(3,5))<=12))
		{
			System.out.println("wrong format !");
			return false;
		}

		//testing if valus between dd/mm/yy are numbers
		if(!(isNub(date.charAt(0))&&isNub(date.charAt(1))&&isNub(date.charAt(3))&&isNub(date.charAt(4))&&isNub(date.charAt(6))&&isNub(date.charAt(7))))
			return false;

		//casting the date to numbers to check them
		int day = StringToNum(date.substring(0,2));
		int month = StringToNum(date.substring(3,5));
		int year = StringToNum(date.substring(6,8));

		//retrun the date is vaid if its leap year
		if(year%4 == 0 && month == 2 && day <=29)
			return true;

		//if not leap year but feb still has more than 28 days return invaid
		else if(year%4!=0 && month == 2 && day > 28)
			return false;

		//if month number(jan=1 feb=2 ..) is even and days greater than 31 return invalid
		if(month%2 == 0 && day > 30)
			return false;

		//if month is number is odd but days are more than 31 return invaild
		if(month%2 != 0 && day > 31)
			return false;

		//finally if it passes all conditions its vaild date
		return true;
	}

	private void printError(String message)
	{
		System.out.println("invaild input try again "+message);
		accept();
	}

	public static void main(String[] args)
	{
		MSEB mseb=new MSEB();
		mseb.accept();
		mseb.calculate();
		mseb.Display();
		// System.out.println(mseb.NumToString(16016));
		// System.out.println(mseb.NumToString(10));
		// System.out.println(mseb.NumToString(11));
		// System.out.println(mseb.NumToString(100));
		// System.out.println(mseb.NumToString(55555));
		// System.out.println(mseb.NumToString(10000));
		// System.out.println(mseb.NumToString(1900099));
		// int num=(int)Math.round(Math.random()*100000);
		// System.out.println(num);
		// System.out.println(mseb.NumToString(num));

	}
}
