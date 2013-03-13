package com.employee;

import java.util.ArrayList;
import java.util.List;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class EmployeeTest 
{
	 EmployeeService employeeService = new EmployeeServiceImpl();	
	
	@Test
	public void sortEmployeeByAge() 
	 {
		   
		    EmployeeBean bean1=new EmployeeBean(1,"Ashwin",22,10000);
			EmployeeBean bean2=new EmployeeBean(3,"Sachin",24,40000);
			EmployeeBean bean3=new EmployeeBean(2,"Vivek",26,60000);
			EmployeeBean bean4=new EmployeeBean(4,"Krish",23,20000);
			EmployeeBean bean5=new EmployeeBean(5,"Amit",28,30000);
			
			List<EmployeeBean> employeeList=new ArrayList<EmployeeBean>();
			
			employeeList.add(bean1);
			employeeList.add(bean2);
			employeeList.add(bean3);
			employeeList.add(bean4);
			employeeList.add(bean5);
			
			employeeService.sortEmployeeByAge(employeeList);

			
			EmployeeBean topElement = employeeList.get(0);
			EmployeeBean secondElement = employeeList.get(1);  
			
			AssertJUnit.assertEquals(22, topElement.getEmployeeAge());
			AssertJUnit.assertEquals(23, secondElement.getEmployeeAge());
	 }

	@Test
	public void sortEmployeeByName() 
	 {
		   
		    EmployeeBean bean1=new EmployeeBean(1,"Ashwin",22,10000);
			EmployeeBean bean2=new EmployeeBean(3,"Sachin",24,40000);
			EmployeeBean bean3=new EmployeeBean(2,"Vivek",26,60000);
			EmployeeBean bean4=new EmployeeBean(4,"Krish",23,20000);
			EmployeeBean bean5=new EmployeeBean(5,"Amit",28,30000);
			
			List<EmployeeBean> employeeList=new ArrayList<EmployeeBean>();
			
			employeeList.add(bean1);
			employeeList.add(bean2);
			employeeList.add(bean3);
			employeeList.add(bean4);
			employeeList.add(bean5);
			
			employeeService.sortEmployeeByName(employeeList);

			
			EmployeeBean topElement = employeeList.get(0);
			EmployeeBean secondElement = employeeList.get(1);  
			
			AssertJUnit.assertEquals("Amit", topElement.getEmployeeName());
			AssertJUnit.assertEquals("Ashwin", secondElement.getEmployeeName());
	 }

	@Test
	public void sortEmployeeByID() 
	 {
		   
		    EmployeeBean bean1=new EmployeeBean(1,"Ashwin",22,10000);
			EmployeeBean bean2=new EmployeeBean(3,"Sachin",24,40000);
			EmployeeBean bean3=new EmployeeBean(2,"Vivek",26,60000);
			EmployeeBean bean4=new EmployeeBean(4,"Krish",23,20000);
			EmployeeBean bean5=new EmployeeBean(5,"Amit",28,30000);
			
			List<EmployeeBean> employeeList=new ArrayList<EmployeeBean>();
			
			employeeList.add(bean1);
			employeeList.add(bean2);
			employeeList.add(bean3);
			employeeList.add(bean4);
			employeeList.add(bean5);
			
			employeeService.sortEmployeeByID(employeeList);

			
			EmployeeBean topElement = employeeList.get(0);
			EmployeeBean secondElement = employeeList.get(1);  
			
			AssertJUnit.assertEquals(1, topElement.getEmployeeID());
			AssertJUnit.assertEquals(2, secondElement.getEmployeeID());
	 }

	@Test
	public void sortEmployeeBySalary() 
	 {
		   
		    EmployeeBean bean1=new EmployeeBean(1,"Ashwin",22,10000);
			EmployeeBean bean2=new EmployeeBean(3,"Sachin",24,40000);
			EmployeeBean bean3=new EmployeeBean(2,"Vivek",26,60000);
			EmployeeBean bean4=new EmployeeBean(4,"Krish",23,20000);
			EmployeeBean bean5=new EmployeeBean(5,"Amit",28,30000);
			
			List<EmployeeBean> employeeList=new ArrayList<EmployeeBean>();
			
			employeeList.add(bean1);
			employeeList.add(bean2);
			employeeList.add(bean3);
			employeeList.add(bean4);
			employeeList.add(bean5);
			
			employeeService.sortEmployeeBySalary(employeeList);

			
			EmployeeBean topElement = employeeList.get(0);
			EmployeeBean secondElement = employeeList.get(1);  
			
			AssertJUnit.assertEquals(10000, topElement.getEmployeeSalary());
			AssertJUnit.assertEquals(20000, secondElement.getEmployeeSalary());
	 }

	@Test
	public void sortEmployeeByAgeR() 
	 {
		   
		    EmployeeBean bean1=new EmployeeBean(1,"Ashwin",22,10000);
			EmployeeBean bean2=new EmployeeBean(3,"Sachin",24,40000);
			EmployeeBean bean3=new EmployeeBean(2,"Vivek",26,60000);
			EmployeeBean bean4=new EmployeeBean(4,"Krish",23,20000);
			EmployeeBean bean5=new EmployeeBean(5,"Amit",28,30000);
			
			List<EmployeeBean> employeeList=new ArrayList<EmployeeBean>();
			
			employeeList.add(bean1);
			employeeList.add(bean2);
			employeeList.add(bean3);
			employeeList.add(bean4);
			employeeList.add(bean5);
			
			employeeService.sortEmployeeByAgeR(employeeList);

			EmployeeBean topElement = employeeList.get(0);
			EmployeeBean secondElement = employeeList.get(1);  
			 		    
			AssertJUnit.assertEquals(28, topElement.getEmployeeAge());
			AssertJUnit.assertEquals(26, secondElement.getEmployeeAge());
	 }

}
