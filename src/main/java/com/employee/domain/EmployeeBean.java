package com.employee.domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;


public class EmployeeBean 
{
	
    @NotNull(message="canot be empty") 
	private Integer employeeID;

    @Min(value=0)
	@Range(max=10000000,min=100000)
	private int employeeSalary;
	
 
	@Min(value = 1)
	private int employeeAge;
	
	@NotEmpty(message="Employee Name cannot be empty")
	private String employeeName;
	
	public EmployeeBean() {	}
	

	public EmployeeBean(int employeeID,String employeeName,int employeeAge,int employeeSalary)
	{
		this.employeeID = employeeID;
		this.employeeSalary = employeeSalary;
		this.employeeAge = employeeAge;
		this.employeeName = employeeName;
	}

	
   public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
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