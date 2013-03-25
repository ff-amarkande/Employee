package com.employee.service;


import java.util.ArrayList;
import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.context.ApplicationContext;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.employee.domain.EmployeeBean;
import com.employee.domain.Order;
import com.employee.domain.SortBy;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class EmployeeServiceImplTest extends AbstractTestNGSpringContextTests
{
	
	private List<EmployeeBean> employeeList = new ArrayList<EmployeeBean>();
	
	@BeforeMethod
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
	
    @AfterMethod
	public void destroy(){
		employeeList.clear();
	}
	
	@Autowired
	private EmployeeService employeeService;
	
	@Test
	public void sortEmployee_nullSortOrder(){
		try{
			employeeService.sortEmployee(null, null, null);
			Assert.fail("This line should not be executed");
		}catch(Exception e){
			Assert.assertNotNull(e);
		}
	}
	
	@Test
	public void sortEmployee_IDAscendingSortOrder()
	{
		List<EmployeeBean> ret = employeeService.sortEmployee(employeeList , SortBy.employeeID, Order.Ascending);
		int id1=ret.get(0).getEmployeeID();
		int id2=ret.get(1).getEmployeeID();
		
		Assert.assertEquals(1,id1);
		Assert.assertEquals(2,id2);
		Assert.assertEquals(5,ret.size());
    }
	
	@Test
	public void sortEmployee_IDDescendingSortOrder()
	{
		List<EmployeeBean> ret = employeeService.sortEmployee(employeeList , SortBy.employeeID, Order.Descending);
		int id1=ret.get(0).getEmployeeID();
		int id2=ret.get(1).getEmployeeID();
		
		Assert.assertEquals(5,id1);
		Assert.assertEquals(4,id2);
		Assert.assertEquals(5,ret.size());
    }
	
	@Test
	public void sortEmployee_NameDescendingSortOrder()
	{
		List<EmployeeBean> ret = employeeService.sortEmployee(employeeList , SortBy.employeeName, Order.Descending);
		String name1=ret.get(0).getEmployeeName();
		String name2=ret.get(1).getEmployeeName();
		
		Assert.assertEquals("Vivek",name1);
		Assert.assertEquals("Sachin",name2);
		Assert.assertEquals(5,ret.size());
    }
	
	
	@Test
	public void sortEmployee_NameAscendingSortOrder()
	{
		List<EmployeeBean> ret = employeeService.sortEmployee(employeeList , SortBy.employeeName, Order.Ascending);
		String name1=ret.get(0).getEmployeeName();
		String name2=ret.get(1).getEmployeeName();
		
		Assert.assertEquals("Amit",name1);
		Assert.assertEquals("Ashwin",name2);
		Assert.assertEquals(5,ret.size());
    }
	
	@Test
	public void sortEmployee_AgeAscendingSortOrder()
	{
		List<EmployeeBean> ret = employeeService.sortEmployee(employeeList , SortBy.employeeAge, Order.Ascending);
		int id1=ret.get(0).getEmployeeAge();
		int id2=ret.get(1).getEmployeeAge();
		
		Assert.assertEquals(22,id1);
		Assert.assertEquals(23,id2);
		Assert.assertEquals(5,ret.size());
    }
	
	@Test
	public void sortEmployee_AgeDescendingSortOrder()
	{
		List<EmployeeBean> ret = employeeService.sortEmployee(employeeList , SortBy.employeeAge, Order.Descending);
		int age1=ret.get(0).getEmployeeAge();
		int age2=ret.get(1).getEmployeeAge();
		
		Assert.assertEquals(28,age1);
		Assert.assertEquals(26,age2);
		Assert.assertEquals(5,ret.size());
    }
	
	@Test
	public void sortEmployee_SalaryAscendingSortOrder()
	{
		List<EmployeeBean> ret = employeeService.sortEmployee(employeeList , SortBy.employeeSalary, Order.Ascending);
		int salary1=ret.get(0).getEmployeeSalary();
		int salary2=ret.get(1).getEmployeeSalary();
		
		Assert.assertEquals(10000,salary1);
		Assert.assertEquals(20000,salary2);
		Assert.assertEquals(5,ret.size());
    }
	
	@Test
	public void sortEmployee_SalaryDescendingSortOrder()
	{
		List<EmployeeBean> ret = employeeService.sortEmployee(employeeList , SortBy.employeeSalary, Order.Descending);
		int salary1=ret.get(0).getEmployeeSalary();
		int salary2=ret.get(1).getEmployeeSalary();
		
		Assert.assertEquals(60000,salary1);
		Assert.assertEquals(40000,salary2);
		Assert.assertEquals(5,ret.size());
    }
	
	@Test
	public void getallEmployees_Test()
	{
		//Step 1 Get All Employees
		List<EmployeeBean> employees = employeeService.getAllEmployees();
		
		//Step 2 Create new Employee
		EmployeeBean bean6=new EmployeeBean(6,"Virat",35,30000);
		employeeList.add(bean6);
		
		//Step 3 Add newly created employee through service
		employeeService.addEmployee(bean6);
		
		//Step 4 Get all Employees again
		List<EmployeeBean> employees1 = employeeService.getAllEmployees();
		
		//Step 5 Check the newly obtained list with previous list
		
		Assert.assertEquals(7, employees1.size());
		
	}
	
	@Test
	public void addEmployee_Test()
	{
		//Step 1 Get All Employees
		//List<EmployeeBean> employees = employeeService.getAllEmployees();
		
		//Step 2 Create new Employee
		EmployeeBean bean6=new EmployeeBean(6,"Virat",35,30000);
		employeeList.add(bean6);
		
		//Step 3 Add newly created employee through service
		employeeService.addEmployee(bean6);
		
		//Step 4 Get all Employees again
		List<EmployeeBean> employees1 = employeeService.getAllEmployees();
		
		//Step 5 Check the newly obtained list with previous list
		
		System.out.println("Employee size "+employees1.size());
		Assert.assertEquals(6, employees1.size());
		Assert.assertEquals("Virat",employees1.get(5).getEmployeeName());
		
	}
	
	
	
	
}
