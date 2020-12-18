// Employe class
class Employee
{

	//properties of each employee
	public int empno;
	public String empname;
	public double salary,bonus,netsalary;
	
	//constructor 
	public Employee(int empno,String empname,double salary)
	{
		this.empno=empno;
		this.empname=empname;
		this.salary=salary;
		this.bonus=this.salary*0.25f;
		this.netsalary=this.salary+this.bonus;
	} 
	public void display()
	{
		System.out.println(this.netsalary);
	}
	public static void main(String[] args)
	{
		Employee e=new Employee(1,"test",2.0);
		e.display();
	}
}