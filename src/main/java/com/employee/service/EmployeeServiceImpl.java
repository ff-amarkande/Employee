package com.employee.service;

import java.util.*;

import javax.annotation.PostConstruct;


import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.comparators.ReverseComparator;
import org.springframework.stereotype.Service;

import com.employee.domain.EmployeeBean;
import com.employee.domain.Order;
import com.employee.domain.SortBy;


@Service("employeeServiceImpl")
public class EmployeeServiceImpl implements EmployeeService
{
	//List<EmployeeBean> employeeList;
	List<EmployeeBean> employeeList = new ArrayList<EmployeeBean>();
	
	@PostConstruct
	public void init(){
		
		EmployeeBean bean1=new EmployeeBean(1,"Ashwin",22,10000);
		EmployeeBean bean2=new EmployeeBean(3,"Sachin",24,40000);
		EmployeeBean bean3=new EmployeeBean(2,"Vivek",26,60000);
		EmployeeBean bean4=new EmployeeBean(4,"Krish",23,20000);
		EmployeeBean bean5=new EmployeeBean(5,"Amit",28,30000);
		employeeList.add(bean1);
		employeeList.add(bean2);
		employeeList.add(bean3);
		employeeList.add(bean4);
		employeeList.add(bean5);
	}
	
	public EmployeeServiceImpl() 
	{	  }
	
	
	
	@SuppressWarnings("unchecked")
	public List<EmployeeBean> sortEmployee(List<EmployeeBean> employeeList, SortBy c,Order s) 
	{
		 BeanComparator namesort;
		 if(CollectionUtils.isEmpty(employeeList) || c == null || s == null){
			 throw new RuntimeException("My Exception");
		 }
		 
		 if(s.name().equals("Ascending"))
		  {
		      namesort=new BeanComparator(c.name());
		  }
		 else
		 {
			 namesort=new BeanComparator(c.name(),new ReverseComparator());
			 
		 }
		      
		 Collections.sort(employeeList, namesort);
		 for (int i = 0; i < employeeList.size(); i++)
	       {
	           System.out.print("Eid "+employeeList.get(i).getEmployeeID());
	           System.out.print(" Name "+employeeList.get(i).getEmployeeName());
	           System.out.print(" Name "+employeeList.get(i).getEmployeeAge());
	           System.out.println(" Salary "+employeeList.get(i).getEmployeeSalary());
	       }
		return employeeList;
		
		
	}



	@Override
	public List<EmployeeBean> getAllEmployees() {
		return employeeList;
	}

	@Override
	public void addEmployee(EmployeeBean employee) {
		employeeList.add(employee);
		
	}

	
	
}
