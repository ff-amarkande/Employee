package com.employee;

public class EmployeeBean 
{
 
	private int employeeID;
	private int employeeSalary;
	private int employeeAge;
	private String employeeName;
	
	public EmployeeBean(int employeeID,String employeeName,int employeeAge,int employeeSalary)
	{
		this.employeeID = employeeID;
		this.employeeSalary = employeeSalary;
		this.employeeAge = employeeAge;
		this.employeeName = employeeName;
	}
	
	public int getEmployeeID() 
	{
		return employeeID;
	}
	
	public void setEmployeeID(int employeeID) 
	{
		this.employeeID = employeeID;
	}
	
	public int getEmployeeSalary()
    {
		return employeeSalary;
	}
	
	public void setEmployeeSalary(int employeeSalary) 
	{
		this.employeeSalary = employeeSalary;
	}
	
	public int getEmployeeAge() 
	{
		return employeeAge;
	}
	
	public void setEmployeeAge(int employeeAge)
	{
		this.employeeAge = employeeAge;
	}
	
	public String getEmployeeName()
	{
		return employeeName;
	}
	
	public void setEmployeeName(String employeeName) 
	{
		this.employeeName = employeeName;
	}
}