package com.employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.beanutils.BeanComparator;

import org.apache.commons.collections.comparators.ReverseComparator;

public class EmployeeServiceImpl implements EmployeeService
{

  public static void main(String[] args)
    {
	    EmployeeServiceImpl employeeTest=new EmployeeServiceImpl();
	    
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
		
		employeeTest.sortEmployeeByAge(employeeList);
		employeeTest.sortEmployeeByID(employeeList);
		employeeTest.sortEmployeeByName(employeeList);
		employeeTest.sortEmployeeBySalary(employeeList);
		employeeTest.sortEmployeeByAgeR(employeeList);
	}

	public void sortEmployeeByName(List<EmployeeBean> employeeList)
	{
		 System.out.println("----Sort By Name-----");
		 BeanComparator namesort=new BeanComparator("employeeName");
		 Collections.sort(employeeList, namesort);
		 for (int i = 0; i < employeeList.size(); i++)
	       {
	           System.out.print("Eid "+employeeList.get(i).getEmployeeID());
	           System.out.print(" Name "+employeeList.get(i).getEmployeeName());
	           System.out.print(" Name "+employeeList.get(i).getEmployeeAge());
	           System.out.println(" Salary "+employeeList.get(i).getEmployeeSalary());
	       }
		 
		
	}

	public void sortEmployeeByID(List<EmployeeBean> employeeList)
	{
		 System.out.println("----Sort By ID-----");
		 BeanComparator namesort=new BeanComparator("employeeID");
		 Collections.sort(employeeList, namesort);
		 for (int i = 0; i < employeeList.size(); i++)
	       {
	           System.out.print("Eid "+employeeList.get(i).getEmployeeID());
	           System.out.print(" Name "+employeeList.get(i).getEmployeeName());
	           System.out.print(" Name "+employeeList.get(i).getEmployeeAge());
	           System.out.println(" Salary "+employeeList.get(i).getEmployeeSalary());
	       }
		
	}

	public void sortEmployeeBySalary(List<EmployeeBean> employeeList) 
	{
		 System.out.println("----Sort By Salary-----");
		 BeanComparator namesort=new BeanComparator("employeeSalary");
		 Collections.sort(employeeList, namesort);
		 for (int i = 0; i < employeeList.size(); i++)
	       {
	           System.out.print("Eid "+employeeList.get(i).getEmployeeID());
	           System.out.print(" Name "+employeeList.get(i).getEmployeeName());
	           System.out.print(" Name "+employeeList.get(i).getEmployeeAge());
	           System.out.println(" Salary "+employeeList.get(i).getEmployeeSalary());
	       }
		
	}

	@SuppressWarnings("unchecked")
	public void sortEmployeeByAge(List<EmployeeBean> employeeList) 
	{
		 System.out.println("----Sort By Age-----");
		 BeanComparator namesort=new BeanComparator("employeeAge");
		 Collections.sort(employeeList, namesort);
		 for (int i = 0; i < employeeList.size(); i++)
	       {
	           System.out.print("Eid "+employeeList.get(i).getEmployeeID());
	           System.out.print(" Name "+employeeList.get(i).getEmployeeName());
	           System.out.print(" Name "+employeeList.get(i).getEmployeeAge());
	           System.out.println(" Salary "+employeeList.get(i).getEmployeeSalary());
	       }
		
	}
	
	
	public void sortEmployeeByAgeR(List<EmployeeBean> employeeList) 
	{
		 System.out.println("----Sort By Reverse Age-----");
		 BeanComparator namesort=new BeanComparator("employeeAge",new ReverseComparator());
		 Collections.sort(employeeList,namesort );
		 for (int i = 0; i < employeeList.size(); i++)
	       {
	           System.out.print("Eid "+employeeList.get(i).getEmployeeID());
	           System.out.print(" Name "+employeeList.get(i).getEmployeeName());
	           System.out.print(" Name "+employeeList.get(i).getEmployeeAge());
	           System.out.println(" Salary "+employeeList.get(i).getEmployeeSalary());
	       }
		
	}

}
